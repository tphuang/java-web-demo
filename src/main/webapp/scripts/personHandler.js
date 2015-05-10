/**
 * Created by htp on 2015/5/10.
 */

$(document).ready(function() {
    $("#profile").click(function() {
        profile();
    });
    $("#login").click(function() {
        login();
    });
});
function profile() {
    var url = 'http://localhost:8080/spring-json/json/person/profile/';
    var query = $('#id').val() + '/' + $('#name').val() + '/'
        + $('#status').val();
    url += query;
    alert(url);
    $.get(url, function(data) {
        alert("id: " + data.id + "\nname: " + data.name + "\nstatus: "
        + data.status);
    });
}
function login() {
    var mydata = '{"name":"' + $('#name').val() + '","id":"'
        + $('#id').val() + '","status":"' + $('#status').val() + '"}';
    alert(mydata);
    $.ajax({
        type: 'POST',
        contentType: 'application/json',
        url: 'http://localhost:8080/spring-json/json/person/login',
        processData: false,
        dataType: 'json',
        data: mydata,
        success: function (data) {
            alert("id: " + data.id + "\nname: " + data.name + "\nstatus: "
            + data.status);
        },
        error: function () {
            alert('Err...');
        }
    });
}
