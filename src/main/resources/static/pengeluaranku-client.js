$(document).ready(function() {


    $("#tambah-pengeluaran").submit(function( event ) {

        // Don't submit the form normally
        event.preventDefault();

        // Get some values from elements on the page
        var $form = $( this ),
            namaPengeluaran = $form.find( "input[name='nama-pengeluaran']" ).val(),
            kodePengeluaran = $form.find( "input[name='kode-pengeluaran']" ).val(),
            tipePengeluaran = $form.find( "input[name='tipe-pengeluaran']:checked" ).val();

        // Compose the data in the format that the API is expecting
        var data = { name: namaPengeluaran, code: kodePengeluaran, type: tipePengeluaran};

        // Send the data using post
        $.ajax({
            url: 'http://localhost:41099/pengeluaranku-service/api/v1/pengeluaran/add',
            type: 'POST',
            data: JSON.stringify(data),
            contentType: "application/json; charset=utf-8",
            dataType: "json",
            async: false,
            success: function(result){
                if(result!=null) {
                    // $('.result-message').empty().append("Selamat! Pengeluaranmu Berhasil Terdaftar");
                    alert("Selamat! Pengeluaranmu Berhasil Terdaftar");
                } else {
                    alert("Yah Pengeluaran Gagal Didaftarkan");
                    // $('.result-message').empty().append("Yah Pengeluaran Gagal Didaftarkan");
                }
            }
        });

    });

    
});

$(document).ready(function() {


$("#tambah-transaksi").submit(function( event ) {

    // Don't submit the form normally
    event.preventDefault();

    // Get some values from elements on the page
    var $form = $( this ),
        namaPengeluaran = $form.find( "input[name='nama-pengeluaran-exist']" ).val(),
        banyakPengeluaran = $form.find( "input[name='besar-pengeluaran']" ).val(),
        detailTransaksi = $form.find( "input[name='keterangan']" ).val();

    // Compose the data in the format that the API is expecting
    var data = { name: namaPengeluaran, amount: banyakPengeluaran, detail_transaksi: detailTransaksi};

    // Send the data using post
    $.ajax({
        url: 'http://localhost:41099/pengeluaranku-service/api/v1/transaksi/add',
        type: 'POST',
        data: JSON.stringify(data),
        contentType: "application/json; charset=utf-8",
        dataType: "json",
        async: false,
        success: function(result){
            if(result!=null) {
                // $('.result-message').empty().append("Selamat! Pengeluaranmu Berhasil Terdaftar");
                alert("Selamat! Transaksimu Berhasil Terdaftar");
            } else {
                alert("Yah Transaksi Gagal Didaftarkan");
                // $('.result-message').empty().append("Yah Pengeluaran Gagal Didaftarkan");
            }
        }
    });

});

});