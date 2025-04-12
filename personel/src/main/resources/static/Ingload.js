let kullaniciEtkilesimiVar = false;

document.addEventListener("DOMContentLoaded", function () {
    document.addEventListener("click", function () {
        kullaniciEtkilesimiVar = true;
    }, { once: true });

    document.getElementById("kelimeForm").addEventListener("submit", function (e) {
        e.preventDefault();

        const formData = {
            kelime: document.querySelector("input[name='kelime']").value,
        };

        fetch("/ingload/ingl/nu", {
            method: "PUT",
            headers: {
                "Content-Type": "application/json"
            },
            body: JSON.stringify(formData)
        })
        .then(res => res.json())
        .then(data => {
            alert("Added", data);
        })
        .catch(err => {
            console.error("Hata:", err);
            alert("Bir hata oluştu!");
        });
    });

    kelimeYukle();
    setInterval(kelimeYukle, 5000);
});

function kelimeYukle() {
    fetch("http://localhost:8080/ingload/ingl/random?limit=1")
        .then(response => response.json())
        .then(data => {
            const kelimeAlani = document.getElementById("kelimeAlani");
            if (data.length > 0) {
                kelimeAlani.textContent = data[0].kelime;

                if (kullaniciEtkilesimiVar) {
                    const zil = document.getElementById("zilSesi");
                    zil.play().catch((e) => {
                        console.warn("Ses çalınamadı:", e);
                    });
                }

            } else {
                kelimeAlani.textContent = "No words found.";
            }
        })
        .catch(error => {
            document.getElementById("kelimeAlani").textContent = "Hata: " + error.message;
        });
}
