<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<!DOCTYPE html>
<html>
<head>
    <title>课程信息显示</title>

    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <!-- 引入bootstrap -->
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/static/css/bootstrap.min.css">
    <!-- 引入JQuery  bootstrap.js-->
    <script src="${pageContext.request.contextPath}/static/js/jquery-3.2.1.min.js"></script>
    <script src="${pageContext.request.contextPath}/static/js/bootstrap.min.js"></script>

    <%--<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">--%>

</head>
<body>
<!-- 顶栏 -->
<jsp:include page="top.jsp"/>
<!-- 中间主体 -->
<div class="container" id="content">
    <div class="row">
        <jsp:include page="menu.jsp"/>
        <div class="col-md-10">
            <div class="panel panel-default">
                <div class="panel-heading">
                    <div class="row">
                        <h1 class="col-md-5">已选课程</h1>
                    </div>
                </div>
                <table class="table table-bordered">
                    <thead>
                    <tr>
                        <th>课程号</th>
                        <th>课程名称</th>
                        <th>授课老师编号</th>
                        <th>上课时间</th>
                        <th>上课地点</th>
                        <th>周数</th>
                        <th>课程类型</th>
                        <th>学分</th>
                        <th>操作</th>
                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach items="${pageBean.items}" var="item">
                        <%--输出还没修完的课程--%>
                        <tr>
                            <td>${item.courseId}</td>
                            <td>${item.courseName}</td>
                            <td>${item.teacherId}</td>
                            <td>${item.courseTime}</td>
                            <td>${item.classroom}</td>
                            <td>${item.courseWeek}</td>
                            <td>${item.courseType}</td>
                            <td>${item.score}</td>
                            <td>
                                <button class="btn btn-default btn-xs btn-info"
                                        onClick="dropCourse(${item.courseId})">退课
                                </button>
                            </td>
                        </tr>
                    </c:forEach>
                    </tbody>
                </table>
                <div class="panel-footer">
                    <c:if test="${pageBean != null}">
                        <nav style="text-align: center">
                            <ul class="pagination">
                                <li>
                                    <a href="${pageContext.request.getContextPath()}/student/course_selected/${pageBean.currentPage-1}">&laquo;上一页</a>
                                </li>
                                <li class="active"><a href="">${pageBean.currentPage}</a></li>
                                <c:if test="${pageBean.currentPage+1 <= pageBean.totalPage}">
                                    <li>
                                        <a href="${pageContext.request.getContextPath()}/student/course_selected/${pageBean.currentPage+1}">${pageBean.currentPage+1}</a>
                                    </li>
                                </c:if>
                                <c:if test="${pageBean.currentPage+2 <= pageBean.totalPage}">
                                    <li>
                                        <a href="${pageContext.request.getContextPath()}/student/course_selected/${pageBean.currentPage+2}">${pageBean.currentPage+2}</a>
                                    </li>
                                </c:if>
                                <c:if test="${pageBean.currentPage+3 <= pageBean.totalPage}">
                                    <li>
                                        <a href="${pageContext.request.getContextPath()}/student/course_selected/${pageBean.currentPage+3}">${pageBean.currentPage+3}</a>
                                    </li>
                                </c:if>
                                <c:if test="${pageBean.currentPage+4 <= pageBean.totalPage}">
                                    <li>
                                        <a href="${pageContext.request.getContextPath()}/student/course_selected/${pageBean.currentPage+4}">${pageBean.currentPage+4}</a>
                                    </li>
                                </c:if>
                                <li>
                                    <a href="${pageContext.request.getContextPath()}/student/course_selected/${pageBean.totalPage}">最后一页&raquo;</a>
                                </li>
                            </ul>
                        </nav>
                    </c:if>
                </div>
            </div>

        </div>
    </div>
</div>
<div class="container" id="footer">
    <div class="row">
        <div class="col-md-12"></div>
    </div>
</div>
</body>
<script type="text/javascript">
    $("#nav").find("li:nth-child(2)").addClass("active");
    <c:if test="${pageBean != null}">
    if (${pageBean.currentPage} == ${pageBean.totalPage}) {
        $(".pagination li:last-child").addClass("disabled")
    }

    if (${pageBean.currentPage} == ${1}) {
        $(".pagination li:nth-child(1)").addClass("disabled")
    }

    </c:if>

    function confirmd() {
        var msg = "您真的确定要删除吗？！";
        return confirm(msg) === true;
    }

    $("#sub").click(function () {
        $("#form1").submit();
    });

    function dropCourse(id) {
        $.ajax({
            type: "POST",
            url: "${pageContext.request.getContextPath()}/student/drop",
            data: {"courseId": id},
            success: function (data) {
                if (data === '1') {
                    alert("退课成功");
                    window.location.reload();
                } else {
                    alert("未知错误");
                }
            }
        });
    }
</script>
</html>