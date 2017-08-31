<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<!DOCTYPE html>
<html>
<head>
    <title>教师信息显示</title>

    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <!-- 引入bootstrap -->
    <link rel="stylesheet" type="text/css" href="${pageContext.request.getContextPath()}/static/css/bootstrap.min.css">
    <!-- 引入JQuery  bootstrap.js-->
    <script src="${pageContext.request.getContextPath()}/static/js/jquery-3.2.1.min.js"></script>
    <script src="${pageContext.request.getContextPath()}/static/js/bootstrap.min.js"></script>

    <%--<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">--%>

</head>
<body>
<!-- 顶栏 -->

<!-- 中间主体 -->
<jsp:include page="top.jsp"/>
<div class="container" id="content">
    <div class="row">
        <jsp:include page="menu.jsp"/>
        <div class="col-md-10">
            <div class="panel panel-default">
                <div class="panel-heading">
                    <div class="row">
                        <h1 class="col-md-5">教师名单管理</h1>
                        <form class="bs-example bs-example-form col-md-5" role="form" style="margin: 20px 0 10px 0;"
                              action="/admin/selectTeacher" id="form1" method="post">
                            <div class="input-group">
                                <input type="text" class="form-control" placeholder="请输入姓名" name="findByName">
                                <span class="input-group-addon btn" onclick="document.getElementById('form1').submit"
                                      id="sub">搜索</span>
                            </div>
                        </form>
                        <button class="btn btn-default col-md-2" style="margin-top: 20px"
                                onClick="location.href='${pageContext.request.getContextPath()}/admin/teacher_add'">
                            添加教师信息
                            <span class="glyphicon glyphicon-plus"></span>
                        </button>

                    </div>
                </div>
                <table class="table table-bordered">
                    <thead>
                    <tr>
                        <th>教师编号</th>
                        <th>姓名</th>
                        <th>性别</th>
                        <th>出生年份</th>
                        <th>学历</th>
                        <th>职称</th>
                        <th>入职年份</th>
                        <th>学院</th>
                        <th>操作</th>
                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach items="${pageBean.items}" var="item">
                        <tr>
                            <td>${item.teacherId}</td>
                            <td>${item.name}</td>
                            <td>${item.gender}</td>
                            <td><fmt:formatDate value="${item.birthDate}" dateStyle="medium"/></td>
                            <td>${item.degree}</td>
                            <td>${item.title}</td>
                            <td><fmt:formatDate value="${item.enrolmentdate}" dateStyle="medium"/></td>
                            <td>${item.college.collegeName}</td>
                            <td>
                                <button class="btn btn-default btn-xs btn-info" onClick="">修改</button>
                                <button class="btn btn-default btn-xs btn-danger btn-primary" onClick="">删除</button>
                                <!--弹出框-->
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
                                    <a href="${pageContext.request.getContextPath()}/admin/teacher_list/{currentPage}${pageBean.currentPage-1}">&laquo;上一页</a>
                                </li>
                                <li class="active"><a href="">${pageBean.currentPage}</a></li>
                                <c:if test="${pageBean.currentPage+1 <= pageBean.totalPage}">
                                    <li>
                                        <a href="${pageContext.request.getContextPath()}/admin/teacher_list/${pageBean.currentPage+1}">${pageBean.currentPage+1}</a>
                                    </li>
                                </c:if>
                                <c:if test="${pageBean.currentPage+2 <= pageBean.totalPage}">
                                    <li>
                                        <a href="${pageContext.request.getContextPath()}/admin/teacher_list/${pageBean.currentPage+2}">${pageBean.currentPage+2}</a>
                                    </li>
                                </c:if>
                                <c:if test="${pageBean.currentPage+3 <= pageBean.totalPage}">
                                    <li>
                                        <a href="${pageContext.request.getContextPath()}/admin/teacher_list/${pageBean.currentPage+3}">${pageBean.currentPage+3}</a>
                                    </li>
                                </c:if>
                                <c:if test="${pageBean.currentPage+4 <= pageBean.totalPage}">
                                    <li>
                                        <a href="${pageContext.request.getContextPath()}/admin/teacher_list/${pageBean.currentPage+4}">${pageBean.currentPage+4}</a>
                                    </li>
                                </c:if>
                                <li>
                                    <a href="${pageContext.request.getContextPath()}/admin/teacher_list/${pageBean.totalPage}">最后一页&raquo;</a>
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
    $("#nav li:nth-child(3)").addClass("active")

    <c:if test="${pageBean != null}">
    if (${pageBean.currentPage} == ${pageBean.totalPage}) {
        $(".pagination li:last-child").addClass("disabled")
    }
    ;

    if (${pageBean.currentPage} == ${1}) {
        $(".pagination li:nth-child(1)").addClass("disabled")
    }
    ;
    </c:if>

    function confirmd() {
        var msg = "您真的确定要删除吗？！";
        if (confirm(msg) == true) {
            return true;
        } else {
            return false;
        }
    }

    $("#sub").click(function () {
        $("#form1").submit();
    });
</script>
</html>