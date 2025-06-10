package com.example.balo_center.module.service.admin.impl;

import com.example.balo_center.domain.entity.Order;
import com.example.balo_center.domain.repo.OrderRepo;
import com.example.balo_center.module.service.admin.OrderService;
import jakarta.persistence.EntityNotFoundException;
import jakarta.persistence.criteria.Predicate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    private OrderRepo repo;

    @Override
    public Page<Order> getAllOrders(int page, int size, String searchId, String status, String sortBy) {
        Sort sort = Sort.by(Sort.Direction.DESC, "date"); // Default sort by date descending
        if (StringUtils.hasText(sortBy)) {
            switch (sortBy) {
                case "dateAsc" -> sort = Sort.by(Sort.Direction.ASC, "date");
                case "dateDesc" -> sort = Sort.by(Sort.Direction.DESC, "date");
                case "priceAsc" -> sort = Sort.by(Sort.Direction.ASC, "totalPrice");
                case "priceDesc" -> sort = Sort.by(Sort.Direction.DESC, "totalPrice");
                default -> sort = Sort.by(Sort.Direction.DESC, "date");
            }
        }

        Pageable pageable = PageRequest.of(page, size, sort);

        Specification<Order> specification = (root, query, criteriaBuilder) -> {
            List<Predicate> predicates = new ArrayList<>();

            if (StringUtils.hasText(searchId)) {
                predicates.add(criteriaBuilder.like(root.get("user").get("fullname"), "%" + searchId + "%"));
            }
            if (StringUtils.hasText(status)) {
                predicates.add(criteriaBuilder.equal(root.get("status"), status));
            }
            return criteriaBuilder.and(predicates.toArray(new Predicate[0]));
        };

        return repo.findAll(specification, pageable);
    }

    @Override
    public Order getOrderById(String id) {
        return repo.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Order not found: " + id));
    }

    @Override
    public Order updateOrderStatus(String id, String status) {
        Order order = getOrderById(id);
        order.setStatus(status);
        return repo.save(order);
    }

    @Override
    public void exportToCSV(PrintWriter writer) throws IOException {
        // Write CSV header
        writer.println("Ngày đặt,Tên khách hàng,Số điện thoại,Địa chỉ,Tổng tiền,Trạng thái,Số lượng");

        // Write data rows
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm");
        List<Order> orders = repo.findAll(); // Get all orders for CSV export

        // For Total Price formatting
        DecimalFormatSymbols symbols = new DecimalFormatSymbols(Locale.ROOT);
        symbols.setGroupingSeparator('.');
        symbols.setDecimalSeparator('.');
        DecimalFormat formatter = new DecimalFormat("#,##0.00", symbols);

        for (Order order : orders) {
            String orderStatus = switch (order.getStatus()) {
                case "PENDING" -> "Chờ xử lý";
                case "PROCESSING" -> "Đang xử lý";
                case "SHIPPED" -> "Đang giao hàng";
                case "DELIVERED" -> "Đã giao hàng";
                case "CANCELLED" -> "Đã hủy";
                default -> order.getStatus();
            };

            writer.println(String.format("%s,%s,%s,%s,%s,%s,%d",
                    escapeCsvField(dateFormat.format(order.getDate())),
                    escapeCsvField(order.getUser().getFullname()),
                    escapeCsvField(order.getPhone()),
                    escapeCsvField(order.getAddress()),
                    escapeCsvField(formatter.format(order.getTotalPrice())),
                    escapeCsvField(orderStatus),
                    order.getQuality_product()));
        }
    }

    private String escapeCsvField(String field) {
        if (field == null) {
            return "";
        }
        if (field.contains(",") || field.contains("\"") || field.contains("\n") || field.contains("\r")) {
            String escapedField = field.replace(String.valueOf('"'), String.valueOf('"') + String.valueOf('"'));
            return "\"" + escapedField + "\"";
        }
        return field;
    }
}
