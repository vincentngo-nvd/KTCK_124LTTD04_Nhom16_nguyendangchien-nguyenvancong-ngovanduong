const express = require('express');
const bodyParser = require('body-parser');
const { conn, sql } = require('./connect');

const app = express();
app.use(bodyParser.json());

app.get('/canhan',async function(req,res){
    var pool = await conn ;
    var sqlString = "select * from khachhang";
    return await pool.request().query(sqlString,function(err,data){
        if ( data.recordset.length > 0)
            {
             res.send(data.recordset);
            }else{
             res.send(null);
            }
    });
})


app.post('/insertthongtincanhan', async (req, res) => {
    const { tenkh } = req.body;

    // Ghi log thông tin nhận được
    console.log("Chèn tài khoản:", tenkh);

    try {
        const pool = await conn;

        // Lấy giá trị makh lớn nhất
        const maxMakhResult = await pool.request().query("SELECT ISNULL(MAX(makh), 0) AS maxMakh FROM khachhang");
        const newMakh = maxMakhResult.recordset[0].maxMakh + 1;

        // Chèn thông tin vào bảng khachhang
        const insertCustomerQuery = `
            INSERT INTO khachhang (makh, tenkhachhang,gioitinh,diachi,email)
            VALUES (@makh, @tenkh,@gioitinh,@diachi,@email)
        `;
        await pool.request()
            .input('makh', sql.Int, newMakh)
            .input('tenkh', sql.NVarChar, tenkh) // Changed to NVarChar for better support of Unicode
            .input('tenkh', sql.NVarChar, tenkh) // Changed to NVarChar for better support of Unicode
            .input('tenkh', sql.NVarChar, tenkh) // Changed to NVarChar for better support of Unicode
            .query(insertCustomerQuery);

        res.json({
            status: 201,
            message: "Thêm khách hàng thành công",
            data: { makh: newMakh, tenkh }
        });
    } catch (error) {
        console.error("Lỗi truy xuất:", error);
        res.status(500).json({
            status: 500,
            message: "Lỗi truy xuất",
            error: error.message // Return the error message for debugging
        });
    }
});
app.delete('/deletekhachhang', async (req, res) => {
    const { makh } = req.query; // Get makh from query parameters

    // Validate makh
    if (!makh) {
        return res.status(400).json({
            status: 400,
            message: "Parameter 'makh' is required.",
        });
    }

    try {
        const pool = await conn;

        // Delete customer from khachhang table
        const deleteCustomerQuery = `
            DELETE FROM khachhang
            WHERE makh = @makh
        `;
        const result = await pool.request()
            .input('makh', sql.Int, makh)
            .query(deleteCustomerQuery);

        if (result.rowsAffected[0] === 0) {
            return res.status(404).json({
                status: 404,
                message: "Khách hàng không tìm thấy.",
            });
        }

        res.json({
            status: 200,
            message: "Xóa khách hàng thành công.",
        });
    } catch (error) {
        console.error("Lỗi truy xuất:", error);
        res.status(500).json({
            status: 500,
            message: "Lỗi truy xuất.",
            error: error.message // Return the error message for debugging
        });
    }
});
// Khởi động server
app.listen(3009, () => {
    console.log('Server is running on port 3009');
});

// Xuất app và kết nối
module.exports = {
    app,
    conn,
    sql
};