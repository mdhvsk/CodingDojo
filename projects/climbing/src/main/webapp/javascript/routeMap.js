/**
 * 
 */
 
 // Initialize and add the map
function initMap() {
  // The location of Uluru
  const uluru = { lat: 37.322998, lng: -122.032181 };
  // The map, centered at Uluru
  const map = new google.maps.Map(document.getElementById("map"), {
    zoom: 10,
    center: uluru,
  });
  // The marker, positioned at Uluru
  const marker = new google.maps.Marker({
    position: uluru,
    map: map,
  });
  const marker2 = new google.maps.Marker({
    position: { lat: 34.322998, lng: -125.032181 },
    map: map,
  });
}

window.initMap = initMap;


 
