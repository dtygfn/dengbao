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
  <div id="main" style="width: 1200px;height:500px;"></div>
  <script type="text/javascript">
      // 基于准备好的dom，初始化echarts实例
      var myChart = echarts.init(document.getElementById('main'));

      var arr = new Array();
      var index = 0;
      <c:forEach items="${perChartList}" var="perChart">
          arr[index++] = ${perChart.num};
      </c:forEach>

      // 指定图表的配置项和数据
      var option = {
          title: {
              text: '员工职称等级分类统计图'
          },
          tooltip: {
              show: true
          },
          legend: {
              data:['员工个数']
          },
          xAxis : [
              {
                  type : 'category',
                  data : [
                      <c:forEach items="${perChartList}" var="perChart">
                      ["${perChart.title}"],
                      </c:forEach>
                  ]
              }
          ],
          yAxis : [
              {
                  type : 'value'
              }
          ],
          series : [
              {
                  name:'员工个数',
                  type:'bar',
                  data: arr
              }
          ]
      };

      // 使用刚指定的配置项和数据显示图表。
      myChart.setOption(option);
  </script>
  </body>
</html>