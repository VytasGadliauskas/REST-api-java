document.getElementById("tablediv").addEventListener("load", showResultTable());
document.getElementById("tablecaliculated").addEventListener("load", showResultCaliculatedTable());

function showResultTable(){
    let jsondata;
    const xmlhttp = new XMLHttpRequest();
    xmlhttp.onload = function () {
         jsondata = JSON.parse(this.responseText);
    }
    xmlhttp.open("GET", "/result", false);
    xmlhttp.send();
    let tablediv="tablediv";
    convertJsontoHtmlTable(jsondata,tablediv);
}

function showResultCaliculatedTable(){
    let jsondata;
    const xmlhttp = new XMLHttpRequest();
    xmlhttp.onload = function () {
         jsondata = JSON.parse(this.responseText);
    }
    xmlhttp.open("GET", "/resultcaliculated", false);
    xmlhttp.send();
    let tablediv="tablecaliculated";
    convertJsontoHtmlTable(jsondata,tablediv);
}

function convertJsontoHtmlTable(jsondata,tablediv) {
    var tablecolumns = [];
    for (var i = 0; i < jsondata.length; i++) {
        for (var key in jsondata[i]) {
            if (tablecolumns.indexOf(key) === -1) {
                tablecolumns.push(key);
            }
        }
    }

    var tabledata = document.createElement("table");

    var tr = tabledata.insertRow(-1);

    for (var i = 0; i < tablecolumns.length; i++) {
        var th = document.createElement("th");
        th.innerHTML = tablecolumns[i];
        tr.appendChild(th);
    }

    for (var i = 0; i < jsondata.length; i++) {
        tr = tabledata.insertRow(-1);
        for (var j = 0; j < tablecolumns.length; j++) {
            var tabCell = tr.insertCell(-1);
            tabCell.innerHTML = jsondata[i][tablecolumns[j]];
        }
    }

    var tabledivcontainer = document.getElementById(tablediv);
    tabledivcontainer.innerHTML = "";
    tabledivcontainer.appendChild(tabledata);
}


