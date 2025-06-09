package com.example.balo_center.module.controller.admin;

import com.example.balo_center.domain.dto.UserFormDTO;
import com.example.balo_center.module.service.admin.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/admin/user")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping("/add")
    public String addUser(@ModelAttribute UserFormDTO form, RedirectAttributes redirectAttributes) {
        try {
            userService.saveUser(form);
            redirectAttributes.addFlashAttribute("successMessage", "Thêm người dùng thành công");
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("errorMessage", "Lỗi khi thêm mới người dùng");
        }
        return "redirect:/view/admin/user";
    }

    @PostMapping("/update")
    public String editUser(@ModelAttribute UserFormDTO form, RedirectAttributes redirectAttributes) {
        try {
            userService.updateUser(form.getId(), form);
            redirectAttributes.addFlashAttribute("successMessage", "Đã cập nhật thông tin người dùng");
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("errorMessage", "Cập nhật thông tin người dùng thất bại");
        }
        return "redirect:/view/admin/user";
    }

    @PostMapping("/delete")
    public String deleteUser(@RequestParam("userId") String userId, RedirectAttributes redirectAttributes) {
        try {
            userService.deleteUser(userId);
            redirectAttributes.addFlashAttribute("successMessage", "Đã xoá người dùng");
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("errorMessage", "Xoá người dùng thất bại");
        }
        return "redirect:/view/admin/user";
    }

    @PostMapping("/toggle-status")
    public String toggleUserStatus(@RequestParam("userId") String userId, RedirectAttributes redirectAttributes) {
        try {
            userService.toggleUserStatus(userId);
            redirectAttributes.addFlashAttribute("successMessage", "Đã cập nhật trạng thái người dùng");
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("errorMessage", "Cập nhật trạng thái người dùng thất bại");
        }
        return "redirect:/view/admin/user";
    }
}
