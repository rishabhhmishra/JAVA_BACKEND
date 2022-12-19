<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
   <head>
         <meta charset="UTF-8" />
         <meta http-equiv="X-UA-Compatible" content="IE=edge" />
         <meta name="viewport" content="width=device-width, initial-scale=1.0" />
         <link rel="stylesheet" href="style.css" />
       </head>
<body>

    <form method="post" action="/ServletProject/EmployeeApp" onSubmit="return validateForm();">
        <div style="max-width: 400px;">
        </div>
        <div style="padding-bottom: 18px;">Legal Name<span style="color: red;"> *</span><br />
            <input type="text" id="data_1" name="name" style="max-width : 450px;" class="form-control" />
        </div>
        <div style="padding-bottom: 18px;">Mobile Number<span style="color: red;"> *</span><br />
            <input type="text" id="data_2" name="cno" style="max-width : 450px;" class="form-control" />
        </div>
        <div style="padding-bottom: 18px;">Address Line 1<span style="color: red;"> *</span><br />
            <textarea id="data_3" false name="add1" style="max-width : 450px;" rows="2"
                class="form-control"></textarea>
        </div>
        <div style="padding-bottom: 18px;">Address Line 2<br />
            <textarea id="data_4" false name="add2" style="max-width : 450px;" rows="2"
                class="form-control"></textarea>
        </div>
        <div style="padding-bottom: 18px;">State<span style="color: red;"> *</span><br />
            <input type="text" id="state" name="state" style="max-width : 450px;" class="form-control" />
        </div>
      
        <div style="padding-bottom: 18px;"><input name="skip_Submit" value="Submit" type="submit" /></div>
        <div>

    </form>

    <script type="text/javascript">
        function validateForm() {
            if (isEmpty(document.getElementById('name').value.trim())) {
                alert('Enter Name is required!');
                return false;
            }
            if (isEmpty(document.getElementById('cno').value.trim())) {
                alert('Mobile Number is required!');
                return false;
            }
            if (isEmpty(document.getElementById('add1').value.trim())) {
                alert('Address Line 1 is required!');
                return false;
            }
            if (isEmpty(document.getElementById('state').value.trim())) {
                alert('State is required!');
                return false;
            }
            return true;
        }
             // function isEmpty(str) { return (str.length === 0 || !str.trim()); }
               // function validateEmail(email) {
               //     var re = /^([\w-]+(?:\.[\w-]+)*)@((?:[\w-]+\.)*\w[\w-]{0,66})\.([a-z]{2,15}(?:\.[a-z]{2})?)$/i;
               //     return isEmpty(email) || re.test(email);
               // }
        }
    </script>
       <footer><a href="/ServletProject/ShowEmployee" strong style="color: orange">Show Records</a></footer>
        <footer > Made by <strong style="color: orange;">Rxbh</strong> .</footer>

</body>

</html>