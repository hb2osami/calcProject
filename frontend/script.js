const url = "http://localhost:8080/api/add";


/**
 * Client function to call the add method present in the API
 */
function add_number() {

    var fNumber = parseFloat(document.getElementById("Text1").value);
    var sNumber = parseFloat(document.getElementById("Text2").value);
    //var result = first_number + second_number;
    var result;
    $.post(url, { num1: fNumber, num2: sNumber },
        function (returnedData) {
            result = returnedData;
			document.getElementById("txtresult").value = result;
        }).fail(function () {
            alert('Cant connect to APi');
        });

    
}