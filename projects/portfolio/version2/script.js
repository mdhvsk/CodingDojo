window.addEventListener("scroll", function (event) {
    var scroll = this.scrollY;
    element = document.querySelector("#nav")
    navi = document.querySelectorAll("#nav a")
    if (scroll > 5) {
        document.body.style.backgroundColor = "white";
        element.style.backgroundColor = "white";
        element.style.color = "black";
        for (var i = 0; i < navi.length; i++) {
            navi[i].style.color = "black"
        }
    }
    else {
        document.body.style.backgroundColor = "black";
        element.style.backgroundColor = "black";
        element.style.color = "white";
        for (var i = 0; i < navi.length; i++) {
            navi[i].style.color = "white"
        }
    }
})