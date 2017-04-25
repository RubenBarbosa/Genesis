var chart = AmCharts.makeChart( "chartdiv", {
  "type": "pie",
  "theme": "light",
  "titles": [ {
    "text": "Febrero",
    "size": 16
  } ],
  "dataProvider": [ {
    "country": "Primer semana",
    "visits": 7252
  }, {
    "country": "Segunda semana",
    "visits": 4548
  }, {
    "country": "Tercera semana",
    "visits": 32230
  },{
    "country": "Cuarta semana",
    "visits": 3900
  }, ],
  "valueField": "visits",
  "titleField": "country",
  "startEffect": "elastic",
  "startDuration": 2,
  "labelRadius": 15,
  "innerRadius": "50%",
  "depth3D": 10,
  "balloonText": "[[title]]<br><span style='font-size:14px'><b>[[value]]</b> ([[percents]]%)</span>",
  "angle": 15,
  "export": {
    "enabled": true
  }
} );