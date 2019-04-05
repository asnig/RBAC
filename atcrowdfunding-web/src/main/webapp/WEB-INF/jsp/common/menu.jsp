<%@page pageEncoding="utf-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<ul style="padding-left:0px;" class="list-group">
    <c:forEach items="${rootPermission.children}" var="permission">
        <c:choose>
            <c:when test="${empty permission.children}">
                <li class="list-group-item tree-closed">
                    <a href="${APP_PATH}${permission.url}"><i
                            class="glyphicon glyphicon-dashboard"></i>${permission.name}</a>
                </li>
            </c:when>
            <c:otherwise>
                <li class="list-group-item tree-closed">
                    <span><i class="${permission.icon}"></i> ${permission.name}<span class="badge"
                                                                        style="float:right">${permission.children.size()}</span></span>
                    <ul style="margin-top:10px;display:none;">
                        <c:forEach items="${permission.children}" var="child">
                            <li style="height:30px;">
                                <a href="${child.url}"><i class="${child.icon}"></i>${child.name}</a>
                            </li>
                        </c:forEach>
                    </ul>
                </li>
            </c:otherwise>
        </c:choose>
    </c:forEach>
</ul>