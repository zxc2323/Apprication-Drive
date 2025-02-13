function pdtMotCle()
{
    //alert("cool")
    var saisie = document.getElementById("saisie").value.trim();
    if (!saisie) {
        zone.innerHTML = "";  // 清空内容
        return;  // 直接返回，不发送请求
    }
    var xhr = new XMLHttpRequest()

    xhr.onload = function ()
    {
        console.log("Requête envoyée: " + xhr.status); // 打印请求状态

        if(xhr.status===200)
        {
            var zone = document.getElementById("zoneff")
            zone.innerHTML = "";

            var xml = xhr.responseXML; // 解析 XML 响应
            var produits = xml.getElementsByTagName("produit");

            for (let i = 0; i < produits.length; i++) {
                let id = produits[i].getElementsByTagName("id")[0].textContent;
                let nom = produits[i].getElementsByTagName("nom")[0].textContent;
                let prix = produits[i].getElementsByTagName("prix")[0].textContent;
                let poids = produits[i].getElementsByTagName("poids")[0].textContent;
                let nutriscore = produits[i].getElementsByTagName("nutriscore")[0].textContent;

                let produitHTML = `<p>${id} - ${nom} - ${prix}€ - ${poids}g - Nutriscore: ${nutriscore}</p>`;
                zone.innerHTML += produitHTML;
            }
        }
    }
    xhr.open("GET","ServletConsulter?saisie=" + encodeURIComponent(saisie))
    xhr.send()
}

function afficherRayon() {
    //alert("cool")
}










//Detecter l'action utilisateur
document.addEventListener("DOMContentLoaded",()=>{
    document.getElementById("saisie").addEventListener("keyup",pdtMotCle);
    document.getElementById("bt_rayon").addEventListener("click",afficherRayon);
});