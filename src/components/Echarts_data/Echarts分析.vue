<template>
<center>
  <div ref="main" id="maindom"></div>
  </center>
</template>

<script>
import { onMounted, ref } from 'vue';
import * as echarts from 'echarts'
export default {
    setup(){
     let main =  ref(null)
     function   InitEcharts(){
        var myChart = echarts.init(main.value); 
        myChart.setOption({
            title: {
                x: 'center',
                text: 'ECharts Chart Statistics',
                subtext: 'Rainbow bar example'
            },
            tooltip: {
                trigger: 'item'
            },
            toolbox: {
                show: true,
                feature: {
                    dataView: {show: true, readOnly: false},
                    restore: {show: true},
                    saveAsImage: {show: true}
                }
            },
            calculable: true,
            grid: {
                borderWidth: 0,
                y: 80,
                y2: 60
            },
            xAxis: [
                {
                    type: 'category',
                    show: false,
                    data: ['Line', 'Bar', 'Scatter', 'K', 'Pie', 'Radar', 'Chord', 'Force', 'Map', 'Gauge', 'Funnel']
                }
            ],
            yAxis: [
                {
                    type: 'value',
                    show: false
                }
            ],
            series: [
                {
                    name: 'ECharts Ion Number Statistics',
                    type: 'bar',
                    itemStyle: {
                        normal: {
                            color: function(params) {
                                // build a color map as your need.
                                var colorList = [
                                    '#C1232B','#B5C334','#FCCE10','#E87C25','#27727B',
                                    '#FE8463','#9BCA63','#FAD860','#F3A43B','#60C0DD',
                                    '#D7504B','#C6E579','#F4E001','#F0805A','#26C0C0'
                                ];
                                return colorList[params.dataIndex]
                            },
                            label: {
                                show: true,
                                position: 'top',
                                formatter: '{b}\n{c}'
                            }
                        }
                    },
                    data: [12,21,10,4,12,5,6,5,25,23,7],
                    markPoint: {
                        tooltip: {
                            trigger: 'item',
                            backgroundColor: 'rgba(0,0,0,0)',
                            formatter: function(params){
                                return '<img src="' 
                                        + params.data.symbol.replace('image://', '')
                                        + '"/>';
                            }
                        },
              data: [
                  {xAxis:0, y: 350, name:'Line', symbolSize:20, symbol: 'image://https://www.jwtechwriter.com/demos/echarts/line.png'},
                  {xAxis:1, y: 350, name:'Bar', symbolSize:20, symbol: 'image://https://www.jwtechwriter.com/demos/echarts/bar.png'},
                  {xAxis:2, y: 350, name:'Scatter', symbolSize:20, symbol: 'image://https://www.jwtechwriter.com/demos/echarts/scatter.png'},
                  {xAxis:3, y: 350, name:'K', symbolSize:20, symbol: 'image://https://www.jwtechwriter.com/demos/echarts/k.png'},
                  {xAxis:4, y: 350, name:'Pie', symbolSize:20, symbol: 'image://https://www.jwtechwriter.com/demos/echarts/pie.png'},
                  {xAxis:5, y: 350, name:'Radar', symbolSize:20, symbol: 'image://https://www.jwtechwriter.com/demos/echarts/radar.png'},
                  {xAxis:6, y: 350, name:'Chord', symbolSize:20, symbol: 'image://https://www.jwtechwriter.com/demos/echarts/chord.png'},
                  {xAxis:7, y: 350, name:'Force', symbolSize:20, symbol: 'image://https://www.jwtechwriter.com/demos/echarts/force.png'},
                  {xAxis:8, y: 350, name:'Map', symbolSize:20, symbol: 'image://https://www.jwtechwriter.com/demos/echarts/map.png'},
                  {xAxis:9, y: 350, name:'Gauge', symbolSize:20, symbol: 'image://https://www.jwtechwriter.com/demos/echarts/gauge.png'},
                  {xAxis:10, y: 350, name:'Funnel', symbolSize:20, symbol: 'image://https://www.jwtechwriter.com/demos/echarts/funnel.png'},
              ]
          }
      }
  ]
});
    }
    onMounted(()=>{
        InitEcharts()
    })
    return{
        main
    }
    }

}
</script>

<style scoped>
body {
	background-color: #fff;
	font-family: Arial, Helvetica, sans-serif;
	font-size: 16px; 
	color: #000;
}

a:link, a:visited {
	color: #4682b4;
}

a:hover {
	color: #4169e1;
}

#maindom	{
	width:500px;
	height: 500px;
	border: 1px solid #ccc;
	padding: 10px;
}
</style>