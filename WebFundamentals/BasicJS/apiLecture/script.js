async function gotMoney(){
    console.log("Young mula baaaby")
    var response = await fetch("https://api.coingecko.com/api/v3/coins/markets?vs_currency=usd&order=market_cap"
    +"desc&per_page=100&page=1&sparkline=false");

    var coinData = await response.json();
    console.log(coinData)


    for (i=0;i<coinData.length;i++) {
        console.log(coinData[i])
        let currentCoin = coinData[i]

        let pTag = document.createElement("p")
        pTag.innerText = currentCoin.name;
        let div = document.querySelector("#coinList");

        div.appendChild(pTag)

    }
}