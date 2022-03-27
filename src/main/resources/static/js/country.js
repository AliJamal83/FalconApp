
$('document').ready(function(){

    $('table #editButton').on('click',function(event){
        event.preventDefault();

        // we want the url to be --> /countries/findById/?id=1
        /* When we get the country from this get request is will makes a et request to the url --> /countries/findById/?id=1
        * and the particular button displayed it  */
        var href = $(this).attr('href');

        $.get(href, function(country, status) {
           $('#idEdit').val(country.id);
           $('#descriptionEdit').val(country.description);
           $('#capitalEdit').val(country.capital);
           $('#codeEdit').val(country.code);
           $('#continentEdit').val(country.continent);
           $('#nationalityEdit').val(country.nationality);
        });

        $('#editModal').modal();
    });
});