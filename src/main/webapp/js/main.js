document.querySelector("main").style.height = window.innerHeight - 150 + "px";

function showEditCustomer(id, fullName, birthday, gender, identifyNumber, phone, email, address, customerTypeId) {
    $(".modal-title").text("Edit Customer");
    $("input[name='id']").val(id);
    $("input[name='fullName']").val(fullName);
    $("input[name='birthday']").val(birthday);
    gender == "true" ? $("#rdMale").prop("checked", true) : $("#rdFemale").prop("checked", true);
    $("input[name='identifyNumber']").val(identifyNumber);
    $("input[name='phone']").val(phone);
    $("input[name='email']").val(email);
    $("input[name='address']").val(address);
    $("select[name='customerType'] option").each(function () {
        if (this.value == customerTypeId) {
            $(this).prop("selected", true)
            return;
        }
    });
}

function resetCustomerForm() {
    $("input[name='id']").val("0");
    $("input[name='fullname'],input[name='birthday'],input[name='identifyNumber'],input[name='phone'],input[name='email'],input[name='address']").val("");
}

function deleteItem(id) {
    $("#idDelete").val(id);
    $("#titleDelete").text(document.title);

}


