var chart = AmCharts.makeChart("chartdiv", {
    "type": "pie",
    "theme": "light",
    "innerRadius": "40%",
    "gradientRatio": [-0.4, -0.4, -0.4, -0.4, -0.4, -0.4, 0, 0.1, 0.2, 0.1, 0, -0.2, -0.5],
    "dataProvider": [{
        "country": "María",
        "litres": 501.9
    }, {
        "country": "Rubén",
        "litres": 301.9
    }, {
        "country": "Daniel",
        "litres": 201.1
    }, {
        "country": "Sergio",
        "litres": 165.8
    }, {
        "country": "Carlos",
        "litres": 139.9
    }, {
        "country": "Andrea",
        "litres": 128.3
    }],
    "balloonText": "[[value]]",
    "valueField": "litres",
    "titleField": "country",
    "balloon": {
        "drop": true,
        "adjustBorderColor": false,
        "color": "#FFFFFF",
        "fontSize": 16
    },
    "export": {
        "enabled": true
    }
});

