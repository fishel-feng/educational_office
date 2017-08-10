<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<div class="col-md-2">
    <ul class="nav nav-pills nav-stacked" id="nav">
        <li><a href="${pageContext.request.getContextPath()}/student/course_list/1">所有课程<span class="badge pull-right"></span></a></li>
        <li><a href="${pageContext.request.getContextPath()}/student/course_selected/1">已选课程<span class="badge pull-right"></span></a></li>
        <li><a href="${pageContext.request.getContextPath()}/student/course_finished/1">已修课程<span class="badge pull-right"></span></a></li>
        <li><a href="${pageContext.request.getContextPath()}/student/reset_password">修改密码
            <span class="glyphicon glyphicon-pencil pull-right"></span>
        </a></li>
        <li><a href="/logout">退出系统
            <span class="glyphicon glyphicon-log-out pull-right"></span>
        </a></li>
        <li class="disabled"><a href="##">Responsive</a></li>
    </ul>
</div>