function lagreBillett() {
    const kino = $("#kino");
    const antall = $("#antall");
    const fornavn = $("#fornavn");
    const etternavn = $("#etternavn");
    const telefonnr = $("#telefonnr");
    const epost = $("#epost");

    const enBillett = {
        kino: kino.val(),
        antall: antall.val(),
        fornavn: fornavn.val(),
        etternavn: etternavn.val(),
        telefonnr: telefonnr.val(),
        epost: epost.val(),
    };
    let errorCount = 0;

    if ($("#kino :selected").val()=="none") {
        $("#kinoError").html("Må velge en film");
        errorCount++;
    }
    if (enBillett.antall == "") {
        $("#antallError").html("Må skrive noe inn i antall");
        errorCount++;
    }
    if (enBillett.fornavn == "") {
        $("#fname").html("Må skrive noe inn i fornavn");
        errorCount++;
    }
    if (enBillett.etternavn == "") {
        $("#etternavnError").html("Må skrive noe inn i etternavn");
        errorCount++;
    }
    if (enBillett.telefonnr == "") {
        $("#telefonnrError").html("Må skrive noe inn i telefonnr");
        errorCount++;
    }
    if (enBillett.epost == "") {
        $("#epostError").html("Må skrive noe inn i epost");
        errorCount++;
    }
    if (errorCount === 0) {
        $.post("/lagre", enBillett, function () {
            hentAlle();
        });
        tomVerdier();
    }
}

function hentAlle() {
    $.get("/hentAlle", function (billetter) {
        visFilmer(billetter);
    });
}

function visFilmer(billetter) {
    let ut = "<table class='table table-striped text-info'><tr><th>Kino</th><th>Antall</th><th>Fornavn</th>" +
        "<th>Etternavn</th><th>Telefonnr</th><th>Epost</th></tr>"

    for (let enBillett of Object.values(billetter || {})) {

        ut += "<tr><td>" + enBillett.kino + "</td><td>" + enBillett.antall + "</td><td>" + enBillett.fornavn + "</td><td>"
            + enBillett.etternavn + "</td><td>" + enBillett.telefonnr + "</td><td>" + enBillett.epost + "</td></tr>";
    }
    ut += "</table>"
    $("#film").html(ut);
}

function slettAlle() {
    $.get("/slettAlle", function () {
        hentAlle();
        tomError();
    });
}
function tomVerdier(){
    $("#kino").val("none"); //tøm input-feltene
    $("#antall").val("");
    $("#fornavn").val("");
    $("#etternavn").val("");
    $("#telefonnr").val("");
    $("#epost").val("");
}
function tomError(){
    $("#kinoError").html("");
    $("#antallError").html("");
    $("#fname").html("");
    $("#etternavnError").html("");
    $("#telefonnrError").html("");
    $("#epostError").html("");
}