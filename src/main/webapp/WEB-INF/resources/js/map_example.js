/**
 * Created by sonny on 2016/11/5.
 */
var chart = echarts.init(document.getElementById('chinamap'));
chart.setOption({
    series: [{
        type: 'map',
        map: 'china'
    }]
});
