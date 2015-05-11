/**
 * Created by htp on 2015/5/10.
 */

$(document).ready(function() {
    var webRoot = 'http://localhost:8081/java-web-demo';
    $("#profile").click(function() {
        profile(webRoot);
    });
    $("#login").click(function() {
        login(webRoot);
    });
});
function profile(webRoot) {
    var url = webRoot + '/person/profile/';
    var query = $('#id').val() + '/' + $('#name').val() + '/'
        + $('#status').val();
    url += query;
    alert(url);
    $.get(url, function(data) {
        alert("id: " + data.id + "\nname: " + data.name + "\nstatus: "
        + data.status);
    });
}
function login(webRoot) {
    var mydata = '{"name":"' + $('#name').val() + '","id":"'
        + $('#id').val() + '","status":"' + $('#status').val() + '"}';
    alert(mydata);
    $.ajax({
        type: 'POST',
        contentType: 'application/json',
        url: webRoot + '/person/login',
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
