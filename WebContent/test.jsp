<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>By：DragonDean</title>
<script type="text/javascript">
	//下面用于图片上传预览功能
	function setImagePreview(avalue) {
		var docObj = document.getElementById("doc");
		var imgObjPreview = document.getElementById("preview");
			imgObjPreview.style.display = 'block';
			imgObjPreview.style.width = '150px';
			imgObjPreview.style.height = '180px';
			imgObjPreview.src = window.URL.createObjectURL(docObj.files[0]);
		return true;
	}
</script>
</head>

<body>
	<table width="100%" border="0" cellspacing="0" cellpadding="0">
		<tbody>
			<tr>
				<td height="101" align="center">
					<div id="localImag">
						<img id="preview"
							src="http://blog.chuangling.net/Public/images/top.jpg"
							width="150" height="180"
							style="display: block; width: 150px; height: 180px;">
					</div>
				</td>
			</tr>
			<tr>
				<td align="center" style="padding-top: 10px;"><input
					type="file" name="file" id="doc" style="width: 150px;"
					onchange="javascript:setImagePreview();"></td>
			</tr>
		</tbody>
	</table>
	<!-- form设置了enctype="multipart/form-data" 属性后，就是2进制传输数据了  -->
	<form action="UploadAction" method="post" enctype="multipart/form-data">
		<input type="file" name="upload" />
		<button type="submit">上传</button>
	</form>
</body>
</html>