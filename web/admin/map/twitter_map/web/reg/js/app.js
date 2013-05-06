$(document).on('ready', function() {
	var map = L.map('map').setView([-12.07449, -77.06720], 13);
	L.tileLayer('http://a.tiles.mapbox.com/v3/examples.map-vyofok3q/{z}/{x}/{y}.png', {
		attribution: '',
		maxZoom: 18
	}).addTo(map);
	var polygon = {
		"type": "Feature",
		"properties": {
			"name": "Bounding",
			"style": {
				"color": "#627BAE",
				"weight": 4,
				"opacity": 1
			}
		},
		"geometry": {
			"type": "Polygon",
			"coordinates": [
				[
					[-77.077915114598895, -12.068570259605995],
					[-77.074800721519338, -12.067854992295857],
					[-77.061091431408343, -12.067497358640788],
					[-77.054251687755126, -12.066439359077878],
					[-77.049691858653006, -12.070224315260692],
					[-77.063147824924982, -12.086451942359451],
					[-77.064220725890181, -12.085617463830957],
					[-77.064682669361318, -12.084410450245098],
					[-77.065666161912759, -12.083754788544137],
					[-77.068318611521192, -12.082801098797288],
					[-77.079240119481881, -12.078781658500288],
					[-77.080613884679764, -12.078400136643305],
					[-77.081784083135531, -12.078304515557301],
					[-77.081455875511566, -12.077466201754676],
					[-77.08116647108001, -12.077188379703031],
					[-77.080374773114457, -12.075641139102606],
					[-77.079827985464775, -12.074811633088354],
					[-77.07854109468019, -12.073008705060861],
					[-77.077915114598895, -12.068570259605995]
				]
			]
		}
	};
	var myLayer = L.geoJson(undefined, {
		style: function(feature) {
			return feature.properties.style;
		},
		onEachFeature: function(feature, layer) {
			var popupContent = "<p>Punto de Desechos</p>";
			layer.bindPopup(popupContent);
		}
	});
	myLayer.addData(polygon);
	myLayer.addTo(map);
	myLayer.on('click', onMarkerClick);
	function onMarkerClick(e) {
		console.log(e);
		$('#latitud').attr('value', e.latlng.lat.toFixed(5));
		$('#longitud').attr('value', e.latlng.lng.toFixed(5));
	};
});