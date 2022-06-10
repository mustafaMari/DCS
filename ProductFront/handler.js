var selectedRow = null

refreshData();
function onFormSubmit() {
    var formData = readFormData();
    console.log("selected", selectedRow)
    if (selectedRow == null){
        console.log(formData);
        createNew(formData);
    }
    else
        updateRecord(formData);
    resetForm();

}
async function refreshData() {
    const data = await getAll();
    console.log(`loggs`, data)
    data.products.forEach(d => insertNewRecord(d));
}



function readFormData() {
    var formData = {};
    formData["id"] = Number(document.getElementById("id").value);
    formData["name"] = document.getElementById("name").value;
    formData["quantity"] = Number(document.getElementById("quantity").value);
    formData["price"] = Number(document.getElementById("price").value);
    formData["new"] = document.getElementById("new").checked;
    formData["sold"] = document.getElementById("sold").checked;
    return formData;
}

function insertNewRecord(data) {
    var table = document.getElementById("productList").getElementsByTagName('tbody')[0];
    var newRow = table.insertRow(table.length);
    cell1 = newRow.insertCell(0);
    cell1.innerHTML = data.id;
    cell2 = newRow.insertCell(1);
    cell2.innerHTML = data.name;
    cell3 = newRow.insertCell(2);
    cell3.innerHTML = data.quantity;
    cell4 = newRow.insertCell(3);
    cell4.innerHTML = data.price;
    cell5 = newRow.insertCell(4);
    cell5.innerHTML = data.new;
    cell6 = newRow.insertCell(5);
    cell6.innerHTML = data.sold;
    cell7 = newRow.insertCell(6);
    cell7.innerHTML = `<a onClick="onSell(this)">Sell</a>
                       <a onClick="onEdit(this)">Edit</a>
                       <a onClick="onDelete(this)">Delete</a>`;
}

function resetForm() {
    document.getElementById("id").value = "";
    document.getElementById("name").value = "";
    document.getElementById("quantity").value = "";
    document.getElementById("price").value = "";
    document.getElementById("new").value = "";
    document.getElementById("sold").value = "";
    selectedRow = null;
}

async function onEdit(td) {
    selectedRow = td.parentElement.parentElement;
    const item = await getProduct(selectedRow.cells[0].innerText)
    console.log("item: " + item.product.id)
    document.getElementById("id").value = item.product.id;
    document.getElementById("name").value = item.product.name;
    document.getElementById("quantity").value = item.product.quantity;
    document.getElementById("price").value = item.product.price;
    document.getElementById("new").value = item.product.new;
    document.getElementById("sold").value = item.product.sold;
}
function onSell(td){
    var q = window.prompt("Enter quantity ");
    selectedRow = td.parentElement.parentElement;
    const id = selectedRow.cells[0].innerText
    const current_q = selectedRow.cells[2].innerText
    const quantity = Number(q)
    var update = {};
    update["id"] = id;
    update["quantity"] = quantity;
    sendSellProduct(update).then(response => response.json())
        .then(response => {
            if (response.statusCode !== 200){
                window.alert(response.message)
            }else{
                var final_quantity = current_q - quantity
                selectedRow.cells[2].innerHTML = String(final_quantity)
                if (final_quantity === 0){
                    selectedRow.cells[5].innerHTML = 'true';
                }
            }
        })

}

function updateRecord(formData) {
    selectedRow.cells[0].innerHTML = formData.id;
    selectedRow.cells[1].innerHTML = formData.name;
    selectedRow.cells[2].innerHTML = formData.quantity;
    selectedRow.cells[3].innerHTML = formData.price;
    selectedRow.cells[4].innerHTML = formData.new;
    selectedRow.cells[5].innerHTML = formData.sold;
    console.log("form data: ", formData);
    updateProduct(formData);
}

function onDelete(td) {
    if (confirm('Are you sure to delete this record ?')) {
        row = td.parentElement.parentElement;
        console.log("row: " + row.cells[0].innerText)
        deleteProduct(row.cells[0].innerText)
        document.getElementById("productList").deleteRow(row.rowIndex);
        resetForm();
    }
}

function validate() {
    return true;
}


function getAll() {
 return   fetch('http://localhost:8080/product-service/products')
        .then(response => response.json())
        .then(data => {
            console.log(data)
            return data
        });
}

function getProduct(id) {
    return fetch(`http://localhost:8080/product-service/products/${id}`)
        .then(response => response.json())
        .then(data => {
            console.log(data)
            return data
        });
}

function product(id, name, quantity, price, newP, sold) {
    this.id = id;
    this.name = name;
    this.price = price;
    this.quantity = quantity;
    this.newP = newP;
    this.sold = sold;
}

function createNew(product) {
    console.log('new ', JSON.stringify(product));
    return fetch("http://localhost:8080/product-service/products/new-product", {
        method: 'POST',
        headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json'
        },
        body: JSON.stringify(product),
    })
        .then(response => response.json())
        .then(response => {
            if (response.statusCode !== 201){
                window.alert(response.message)
            }else {
                insertNewRecord(product)
            }
        })



}

function updateProduct(product) {
    fetch("http://localhost:8080/product-service/products/update-product", {
        method: 'POST',
        headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json'
        },
        body: JSON.stringify(product),
    }).then(response => response.json())
        .then(response => {
            if (response.statusCode !== 200){
                window.alert(response.message)
            }
        });

}

function deleteProduct(id) {
    console.log("id", id)
    fetch(`http://localhost:8080/product-service/products/delete/${id}`, {

    }).then(response => response.json())
        .then(response => {
            if (response.statusCode !== 200){
                window.alert(response.message)
            }
        });

}

function sellProduct(id, quantity) {
    this.id = id;
    this.quantity = quantity;
}

function sendSellProduct(sellProduct) {
    return fetch("http://localhost:8080/product-service/products/sell-product", {
        method: 'POST',
        headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json',
        },
        body: JSON.stringify(sellProduct),
    })

}