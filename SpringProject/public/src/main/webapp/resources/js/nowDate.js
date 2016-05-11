/**
 * @author Astafyev Igor
 *         11-405
 *         for SemWork
 */

function date() {
    var d = new Date();
    var day = d.getDay()+1;
    var month = d.getMonth()+1;
    var year = d.getFullYear();

    if (day <= 9) day = "0" + day;
    if (month <= 9) month = "0" + month;

    day_date = " " + day + "." + month+"."+year;
    if (document.layers) {
        document.layers.doc_date.document.write(day_date);
        document.layers.doc_date.document.close();
    }
    else document.getElementById("doc_date").innerHTML = day_date;
    setTimeout("date()", 360000);
}