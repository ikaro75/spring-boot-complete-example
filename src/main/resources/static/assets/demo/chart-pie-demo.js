// Set new default font family and font color to mimic Bootstrap's default styling
Chart.defaults.global.defaultFontFamily = '-apple-system,system-ui,BlinkMacSystemFont,"Segoe UI",Roboto,"Helvetica Neue",Arial,sans-serif';
Chart.defaults.global.defaultFontColor = '#292b2c';

// Pie Chart Example
var ctx = document.getElementById("myPieChart");
var bcData =  document.getElementById("bcPercentages").value.replace("[","").replace("]","").replaceAll(" ","");
var bcLabels = document.getElementById("bcLabels").value.replace("[","").replace("]","").replaceAll(" ","");

bcData = bcData.split(",");
bcLabels = bcLabels.split(",");

var myPieChart = new Chart(ctx, {
  type: 'pie',
  data: {
    labels: bcLabels,
    datasets: [{
      data: bcData,
      backgroundColor: ['#007bff', '#dc3545', '#ffc107', '#28a745'],
    }],
  },
});
