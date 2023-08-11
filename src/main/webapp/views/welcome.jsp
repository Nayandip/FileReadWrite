<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>File Handling</title>
</head>
<body>




<div id="filediv">
<form method="post">

<h3>File Handling Form</h3>
<hr/><br/>
<label>File Path : <span>*</span></label>
<br/>
<input type="text" name="path" size="50" placeholder="File Path" value=${path}><br/>
<br/>

<label>File Content:</label>
<br/>
<textarea name="fileContent" rows="10" cols="50" placeholder="File Data......." >${fileContent}</textarea><br/>

<font color="red">${errorMessage}</font>
<br/><br/>
<input type="submit" name="fetch" value="Fetch Data"/>
<input type="submit" name="save" value="Save"/>
<br/>
</form>
</div>







</body>
</html>