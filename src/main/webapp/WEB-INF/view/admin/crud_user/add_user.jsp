<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<div class="modal fade" id="addUserModal" tabindex="-1" aria-labelledby="addUserModalLabel" aria-hidden="true">
    <div class="modal-dialog modal-xl">
        <div class="modal-content">
            <form action="/admin/user/add" method="post" id="adduserform">
                <div class="modal-header">
                    <h5 class="modal-title" id="addUserModalLabel">Thêm người dùng mới</h5>
                    <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Đóng"></button>
                </div>
                <div class="modal-body">
                    <div class="mb-3">
                        <label for="fullname" class="form-label">Họ và tên</label>
                        <input id="fullname" type="text" class="form-control" name="fullname" required>
                    </div>
                    <div class="mb-3">
                        <label for="email" class="form-label">Email</label>
                        <input type="email" class="form-control" id="email" name="email" required>
                    </div>
                    <div class="mb-3">
                        <label for="userPhone" class="form-label">Số điện thoại</label>
                        <input id="userPhone" type="text" class="form-control" name="userPhone" required>
                    </div>
                    <div class="mb-3">
                        <label for="password" class="form-label">Mật khẩu</label>
                        <input type="password" class="form-control" id="password" name="password" required>
                    </div>
                    <div class="mb-3">
                        <label for="role" class="form-label">Vai trò</label>
                        <select class="form-select" id="role" name="role" required>
                            <option value="admin">Admin</option>
                            <option value="editor">Editor</option>
                            <option value="user">User</option>
                        </select>
                    </div>
                    <div class="mb-3">
                        <label for="status" class="form-label">Trạng thái</label>
                        <select class="form-select" id="status" name="status" required>
                            <option value="active">ACTIVE</option>
                            <option value="locked">LOCKED</option>
                        </select>
                    </div>
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Đóng</button>
                    <button type="submit" class="btn btn-primary" id="adduser">Lưu</button>
                </div>
            </form>

        </div>
    </div>
</div>

<script>
    $("#adduser").click(function (){
       var formData = $("#adduserform").serializeArray();
       var json = {};
        $.each(formData, function (i, it) {
            json["" + it.name + ""] = it.value;
        });
     addUser(json);
    });

    function addUser(json){
        $.ajax({
            type: "POST",
            url: "/admin/user/add",
            data: JSON.stringify(json),
            dataType: "json",
            contentType: "application/json",
            success: function () {
                alert("Thêm thành công");
                console.log("Success");
                // window.location.href = "/admin/building-list";
            },
            error: function () {
                alert("Thêm thất bại");
            },
        });

    }

</script>