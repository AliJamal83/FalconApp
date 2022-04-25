
// we want the url to be --> /countries/findById/?id=1
//         /* When we get the country from this get request is will makes a et request to the url --> /countries/findById/?id=1
//         * and the particular button displayed it  */

$('document').ready(function() {

    $('.table .btn-primary').on('click',function(event){
        event.preventDefault();
        var href= $(this).attr('href');
        $.get(href, function(country, status){
            $('#idEdit').val(country.id);
            $('#descriptionEdit').val(country.description);
            $('#codeEdit').val(country.code);
        });
        $('#editModal').modal();
    });

    $('.table #detailsButton').on('click',function(event) {
        event.preventDefault();
        var href= $(this).attr('href');
        $.get(href, function(country, status){
            $('#idDetails').val(country.id);
            $('#descriptionDetails').val(country.description);
            $('#codeDetails').val(country.code);
            $('#lastModifiedByDetails').val(country.lastModifiedBy);
            $('#lastModifiedDateDetails').val(country.lastModifiedDate.substr(0,19).replace("T", " "));
        });
        $('#detailsModal').modal();
    });

    $('.table #deleteButton').on('click',function(event) {
        event.preventDefault();
        var href = $(this).attr('href');
        $('#deleteModal #delRef').attr('href', href);
        $('#deleteModal').modal();
    });
});