<%--
  Created by IntelliJ IDEA.
  User: 10727
  Date: 2019/4/2
  Time: 8:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">

    <link rel="stylesheet" href="${APP_PATH}/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="${APP_PATH}/css/font-awesome.min.css">
    <link rel="stylesheet" href="${APP_PATH}/css/main.css">
    <style>
        .tree li {
            list-style-type: none;
            cursor: pointer;
        }

        table tbody tr:nth-child(odd) {
            background: #F4F4F4;
        }

        table tbody td:nth-child(even) {
            color: #C00;
        }
    </style>
</head>

<body>

<nav class="navbar navbar-inverse navbar-fixed-top" role="navigation">
    <div class="container-fluid">
        <div class="navbar-header">
            <div><a class="navbar-brand" style="font-size:32px;" href="#">众筹平台 - 角色维护</a></div>
        </div>
        <div id="navbar" class="navbar-collapse collapse">
            <ul class="nav navbar-nav navbar-right">
                <li style="padding-top:8px;">
                    <div class="btn-group">
                        <button type="button" class="btn btn-default btn-success dropdown-toggle"
                                data-toggle="dropdown">
                            <i class="glyphicon glyphicon-user"></i> 张三 <span class="caret"></span>
                        </button>
                        <ul class="dropdown-menu" role="menu">
                            <li><a href="#"><i class="glyphicon glyphicon-cog"></i> 个人设置</a></li>
                            <li><a href="#"><i class="glyphicon glyphicon-comment"></i> 消息</a></li>
                            <li class="divider"></li>
                            <li><a href="index.html"><i class="glyphicon glyphicon-off"></i> 退出系统</a></li>
                        </ul>
                    </div>
                </li>
                <li style="margin-left:10px;padding-top:8px;">
                    <button type="button" class="btn btn-default btn-danger">
                        <span class="glyphicon glyphicon-question-sign"></span> 帮助
                    </button>
                </li>
            </ul>
            <form class="navbar-form navbar-right">
                <input type="text" class="form-control" placeholder="Search...">
            </form>
        </div>
    </div>
</nav>

<div class="container-fluid">
    <div class="row">
        <div class="col-sm-3 col-md-2 sidebar">
            <div class="tree">
                <ul style="padding-left:0px;" class="list-group">
                    <li class="list-group-item tree-closed">
                        <a href="/main"><i class="glyphicon glyphicon-dashboard"></i> 控制面板</a>
                    </li>
                    <li class="list-group-item">
                        <span><i class="glyphicon glyphicon glyphicon-tasks"></i> 权限管理 <span class="badge"
                                                                                             style="float:right">3</span></span>
                        <ul style="margin-top:10px;">
                            <li style="height:30px;">
                                <a href="/user/index"><i class="glyphicon glyphicon-user"></i> 用户维护</a>
                            </li>
                            <li style="height:30px;">
                                <a href="/role/index" style="color:red;"><i class="glyphicon glyphicon-king"></i>
                                    角色维护</a>
                            </li>
                            <li style="height:30px;">
                                <a href="/permission/index"><i class="glyphicon glyphicon-lock"></i> 许可维护</a>
                            </li>
                        </ul>
                    </li>
                    <li class="list-group-item tree-closed">
                        <span><i class="glyphicon glyphicon-ok"></i> 业务审核 <span class="badge"
                                                                                style="float:right">3</span></span>
                        <ul style="margin-top:10px;display:none;">
                            <li style="height:30px;">
                                <a href="auth_cert.html"><i class="glyphicon glyphicon-check"></i> 实名认证审核</a>
                            </li>
                            <li style="height:30px;">
                                <a href="auth_adv.html"><i class="glyphicon glyphicon-check"></i> 广告审核</a>
                            </li>
                            <li style="height:30px;">
                                <a href="auth_project.html"><i class="glyphicon glyphicon-check"></i> 项目审核</a>
                            </li>
                        </ul>
                    </li>
                    <li class="list-group-item tree-closed">
                        <span><i class="glyphicon glyphicon-th-large"></i> 业务管理 <span class="badge" style="float:right">7</span></span>
                        <ul style="margin-top:10px;display:none;">
                            <li style="height:30px;">
                                <a href="cert.html"><i class="glyphicon glyphicon-picture"></i> 资质维护</a>
                            </li>
                            <li style="height:30px;">
                                <a href="type.html"><i class="glyphicon glyphicon-equalizer"></i> 分类管理</a>
                            </li>
                            <li style="height:30px;">
                                <a href="process.html"><i class="glyphicon glyphicon-random"></i> 流程管理</a>
                            </li>
                            <li style="height:30px;">
                                <a href="advertisement.html"><i class="glyphicon glyphicon-hdd"></i> 广告管理</a>
                            </li>
                            <li style="height:30px;">
                                <a href="message.html"><i class="glyphicon glyphicon-comment"></i> 消息模板</a>
                            </li>
                            <li style="height:30px;">
                                <a href="project_type.html"><i class="glyphicon glyphicon-list"></i> 项目分类</a>
                            </li>
                            <li style="height:30px;">
                                <a href="tag.html"><i class="glyphicon glyphicon-tags"></i> 项目标签</a>
                            </li>
                        </ul>
                    </li>
                    <li class="list-group-item tree-closed">
                        <a href="param.html"><i class="glyphicon glyphicon-list-alt"></i> 参数管理</a>
                    </li>
                </ul>
            </div>
        </div>
        <div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
            <div class="panel panel-default">
                <div class="panel-heading">
                    <h3 class="panel-title"><i class="glyphicon glyphicon-th"></i> 数据列表</h3>
                </div>
                <div class="panel-body">
                    <form class="form-inline" role="form" style="float:left;">
                        <div class="form-group has-feedback">
                            <div class="input-group">
                                <div class="input-group-addon">查询条件</div>
                                <input id="queryText" class="form-control has-success" type="text"
                                       placeholder="请输入查询条件">
                            </div>
                        </div>
                        <button id="findBtn" type="button" class="btn btn-warning"><i
                                class="glyphicon glyphicon-search"></i> 查询
                        </button>
                    </form>
                    <button type="button" onclick="deleteRoles()" class="btn btn-danger"
                            style="float:right;margin-left:10px;"><i
                            class=" glyphicon glyphicon-remove"></i> 删除
                    </button>
                    <button type="button" class="btn btn-primary" style="float:right;"
                            onclick="window.location.href='${APP_PATH}/role/add'"><i
                            class="glyphicon glyphicon-plus"></i> 新增
                    </button>
                    <br>
                    <hr style="clear:both;">
                    <div class="table-responsive">
                        <form id="roleForm">
                            <table class="table  table-bordered">
                                <thead>
                                <tr>
                                    <th width="30">#</th>
                                    <th width="30"><input id="selAllBox" type="checkbox"></th>
                                    <th>名称</th>
                                    <th width="100">操作</th>
                                </tr>
                                </thead>
                                <tbody id="roleData">
                                </tbody>
                                <tfoot>
                                <tr>
                                    <td colspan="6" align="center">
                                        <ul class="pagination">
                                            <li class="disabled"><a href="#">上一页</a></li>
                                            <li class="active"><a href="#">1 <span class="sr-only">(current)</span></a>
                                            </li>
                                            <li><a href="#">2</a></li>
                                            <li><a href="#">3</a></li>
                                            <li><a href="#">4</a></li>
                                            <li><a href="#">5</a></li>
                                            <li><a href="#">下一页</a></li>
                                        </ul>
                                    </td>
                                </tr>
                                </tfoot>
                            </table>
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>

<script src="${APP_PATH}/jquery/jquery-2.1.1.min.js"></script>
<script src="${APP_PATH}/bootstrap/js/bootstrap.min.js"></script>
<script src="${APP_PATH}/script/docs.min.js"></script>
<script src="${APP_PATH}/layer/layer.js"></script>
<script type="text/javascript">
    var likeFlag = false;
    $(function () {
        $(".list-group-item").click(function () {
            if ($(this).find("ul")) {
                $(this).toggleClass("tree-closed");
                if ($(this).hasClass("tree-closed")) {
                    $("ul", this).hide("fast");
                } else {
                    $("ul", this).show("fast");
                }
            }
        });

        pageQuery(1);

        $("#findBtn").click(function () {
            var queryText = $("#queryText").val();
            likeFlag = queryText !== '';
            pageQuery(1);
        });

        $("#selAllBox").click(function () {
            var flag = this.checked;
            $("#roleData :checkbox").each(function () {
                this.checked = flag;
            })
        })

    });

    function pageQuery(pageNo) {
        var index = null;
        var queryData = {"pageNo": pageNo, "pageSize": 5};
        if (likeFlag) {
            queryData.queryText = $("#queryText").val();
        }
        $.ajax({
            type: "POST",
            url: "${APP_PATH}/role/pageQuery",
            data: queryData,
            beforeSend: function () {
                index = layer.msg('处理中', {icon: 16});
            },
            success: function (result) {
                layer.close(index);
                if (result.success) {

                    var rolePage = result.data;
                    var roles = rolePage.datas;
                    var tableContent = "";
                    var pageContent = "";

                    $.each(roles, function (i, role) {
                        tableContent += '<tr>';
                        tableContent += '	<td>' + (i + 1) + '</td>';
                        tableContent += '	<td><input name="roleid" value="' + role.id + '" type="checkbox"></td>';
                        tableContent += '	<td>' + role.rolename + '</td>';
                        tableContent += '	<td>';
                        tableContent += '		<button type="button" class="btn btn-success btn-xs"><i class=" glyphicon glyphicon-check"></i></button>';
                        tableContent += '		<button type="button" onclick="toEdit(' + role.id + ')" class="btn btn-primary btn-xs"><i class=" glyphicon glyphicon-pencil"></i></button>';
                        tableContent += '		<button type="button" onclick="deleteRole(' + role.id + ',\'' + role.rolename + '\')" class="btn btn-danger btn-xs"><i class=" glyphicon glyphicon-remove"></i></button>';
                        tableContent += '	</td>';
                        tableContent += '</tr>';
                    });

                    if (pageNo > 1) {
                        pageContent += '<li><a href="javascript:" onclick="pageQuery(' + (pageNo - 1) + ')">上一页</a></li>';
                    } else {
                        pageContent += '<li class="disabled"><a href="#">上一页</a></li>';
                    }

                    for (var i = 1; i <= rolePage.totalPage; i++) {
                        if (pageNo === i) {
                            pageContent += '<li class="active"><a href="#">' + i + '</a></li>';
                        } else {
                            pageContent += '<li><a href="javascript:" onclick="pageQuery(' + i + ')">' + i + '</a></li>';
                        }
                    }

                    if (pageNo < rolePage.totalPage) {
                        pageContent += '<li><a href="javascript:" onclick="pageQuery(' + (pageNo + 1) + ')">下一页</a></li>';
                    } else {
                        pageContent += '<li class="disabled"><a href="#">下一页</a></li>';
                    }
                    $("#roleData").html(tableContent);
                    $(".pagination").html(pageContent);

                } else {
                    layer.msg('角色信息分页查询失败', {
                        icon: 5,
                        time: 2000, //2秒关闭（如果不配置，默认是3秒）
                        anim: 6
                    }, function () {
                    });
                }
            }

        })
    }

    function toEdit(id) {
        window.location.href = "${APP_PATH}/role/edit?id=" + id;
    }

    function deleteRole(id, rolename) {
        var index = null;
        layer.confirm("确定删除角色【" + rolename + "】？", {icon: 3, title: '提示'}, function (cindex) {

            $.ajax({
                type: "POST",
                url: "${APP_PATH}/role/delete",
                data: {"id": id},
                beforeSend: function () {
                    index = layer.msg('处理中', {icon: 16});
                },
                success: function (result) {
                    layer.close(index);
                    if (result) {
                        pageQuery(1);
                    } else {
                        layer.msg('角色删除失败，请重新操作！', {
                            icon: 5,
                            time: 2000, //2秒关闭（如果不配置，默认是3秒）
                            anim: 6
                        }, function () {
                        });
                    }
                }
            });

            layer.close(cindex);
        }, function (cindex) {
            layer.close(cindex);
        });
    }

    function deleteRoles() {
        var index = null;
        var boxes = $("#roleData input:checkbox:checked");
        if (boxes.length === 0) {
            layer.msg('请选择需要删除的角色！', {
                icon: 5,
                time: 2000, //2秒关闭（如果不配置，默认是3秒）
                anim: 6
            }, function () {
            });
            return;
        }
        layer.confirm("确认删除选择的角色？", {icon: 3, title: '提示'}, function (cindex) {
            $.ajax({
                type: "POST",
                url: "${APP_PATH}/role/deleteRoles",
                data: $("#roleForm").serialize(),
                beforeSend: function () {
                    index = layer.msg('处理中', {icon: 16});
                },
                success: function (result) {
                    layer.close(index);
                    if (result) {
                        layer.msg('角色删除成功！', {icon: 6, time: 2000}, function () {
                            pageQuery(1);
                        });
                    } else {
                        layer.msg('角色删除失败，请重新操作！', {
                            icon: 5,
                            time: 2000, //2秒关闭（如果不配置，默认是3秒）
                            anim: 6
                        }, function () {
                        });
                    }
                }
            });

            layer.close(cindex);
        }, function (cindex) {
            layer.close(cindex);
        });
    }


    $("tbody .btn-success").click(function () {
        window.location.href = "assignPermission.html";
    });
</script>
</body>
</html>

