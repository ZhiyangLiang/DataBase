document.addEventListener('DOMContentLoaded', function () {
    const form = document.getElementById('dataForm');
    form.onsubmit = function (event) {
        event.preventDefault();
        const formData = new FormData(form);
        // console.log(form)
        const data = {};
        formData.forEach((value, key) => {
            if(key == "payment_datetime") {
                console.log(value);
                value = formatDateTime(value);
            }
            data[key] = value;
        });
        // console.log(data)
        // console.log(JSON.stringify(data))

        fetch('http://localhost:8080/insert', {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json',
            },
            body: JSON.stringify(data)
        })
            .then(response => response.json())
            .then(data => console.log(data))
            .catch(error => console.error('Error:', error));
    };
});

document.addEventListener('DOMContentLoaded', function () {
    const form = document.getElementById('selectForm');
    form.onsubmit = function (event) {
        event.preventDefault();
        const formData = new FormData(form);
        const data = {};
        formData.forEach((value, key) => {
            data[key] = value;
        });

        fetch('http://localhost:8080/' + data['table_name'], {
            method: 'GET',
        })
            .then(response => response.json())
            .then(data => {
                    let displayArea = document.getElementById('result-area');
                    displayArea.innerHTML = '';
                    data["data"].forEach(function (item){
                        // console.log(item);
                        let pitem = document.createElement('p');
                        pitem.textContent = JSON.stringify(item);
                        console.log(JSON.stringify(item));
                        displayArea.appendChild(pitem);
                    })
                }
            )
            .catch(error => console.error('Error:', error));
    };
});

function formatDateTime(datetime) {
    const dateTimeObj = new Date(datetime);
    return dateTimeObj.toISOString().replace('T', ' ').substring(0, 19);
}
