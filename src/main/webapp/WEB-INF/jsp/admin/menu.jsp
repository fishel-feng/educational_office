<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<div class="col-md-2">
    <ul class="nav nav-pills nav-stacked" id="nav">
        <li><a href="${pageContext.request.contextPath}/admin/course_list/1">课程管理<span class="badge pull-right">8</span></a></li>
        <li><a href="${pageContext.request.contextPath}/admin/student_list/1">学生管理<span class="badge pull-right">59</span></a></li>
        <li><a href="${pageContext.request.contextPath}/admin/teacher_list/1">教师管理<span class="badge pull-right">10</span></a></li>
        <li><a href="${pageContext.request.contextPath}/admin/user_reset">账号密码重置<span class="glyphicon glyphicon-repeat pull-right" ></span></a></li>
        <li><a href="${pageContext.request.contextPath}/admin/password_reset">修改密码<span class="glyphicon glyphicon-pencil pull-right" ></span></a></li>
        <li><a href="${pageContext.request.contextPath}/logout">退出系统<span class="glyphicon glyphicon-log-out pull-right" ></span></a></li>
        <li class="disabled"><a href="##">Responsive</a></li>
    </ul>
</div>