document.getElementById('createButton').addEventListener('click', function() {
  var createDiv = document.getElementById('createDiv');
  if (createDiv.style.display === 'none') {
    createDiv.style.display = 'block'; // 显示 div
  } else {
    createDiv.style.display = 'none'; // 隐藏 div
  }
});

function sendRequest() {
    var inputData = document.getElementById('inputData').value;
    var inputData2 = document.getElementById('inputData2').value;
    var xhr = new XMLHttpRequest();
    xhr.open('POST', 'ListCourse', true);
    xhr.setRequestHeader('Content-Type', 'application/x-www-form-urlencoded');
    xhr.onreadystatechange = function() {
        if (xhr.readyState === 4 && xhr.status === 200) {
            var parser = new DOMParser();
            var xmlDoc = parser.parseFromString(xhr.responseText, "text/xml");
            var status = xmlDoc.getElementsByTagName("status")[0].childNodes[0].nodeValue;
            document.getElementById('resultat').textContent = status;
        } else if (xhr.readyState === 4) {
            document.getElementById('resultat').textContent = 'An error occurred during the request.';
        }
    };
    xhr.send('Nom=' + encodeURIComponent(inputData) + '&pt=' + encodeURIComponent(inputData2));
}