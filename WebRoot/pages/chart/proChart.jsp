<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>ECharts</title>
    <meta charset="utf-8">
    <!-- 引入 ECharts 文件 -->
      <script src="${pageContext.request.contextPath}/js/echarts.common.min.js"></script>
      <script src="${pageContext.request.contextPath}/js/jquery-1.8.3.js"></script>
</head>

<body>    
<!-- 为ECharts准备一个具备大小（宽高）的Dom -->
<div id="main" style="height:500px;"></div>
<script type="text/javascript">
    // 基于准备好的dom，初始化echarts实例
    var myChart = echarts.init(document.getElementById('main'));

    // 指定图表的配置项和数据
    option = {
        title : {
            text: '项目安全保护等级分类统计图',
            x:'center'
        },
        tooltip : {
            trigger: 'item',
            formatter: '{a} <br/>{b} : {c} ({d}%)'
        },
        legend: {
            orient: 'vertical',
            left: 'left',
            data: [
                <c:forEach items="${proChartList}" var="proChart">
                    ["${proChart.level}"],
                </c:forEach>
            ]
        },
        series : [
            {
                name: '项目个数',
                type: 'pie',
                radius : '60%',
                center: ['50%', '60%'],
                data:[
                    <c:forEach items="${proChartList}" var="proChart">
                    {value:"${proChart.num}", name:"${proChart.level}"},
                    </c:forEach>
                ],
                itemStyle: {
                    emphasis: {
                        shadowBlur: 10,
                        shadowOffsetX: 0,
                        shadowColor: 'rgba(0, 0, 0, 0.5)'
                    }
                }
            }
        ]
    };

    // 使用刚指定的配置项和数据显示图表。
    myChart.setOption(option);
</script>
</body>
</html>
