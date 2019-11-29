<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<style type="text/css">
.friendlist {
	margin-top: 5px;
	height: 30px;
	margin-left: 30px;
}

#chatinstruction {
	margin-top: 15px;
	margin-left: 10px;
}

#boxoffriends {
	margin: top: 30px;
}
</style>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>ChatHall</title>
</head>
<body>
	<div>
		<h1>Welcome to the ChatHall</h1>

		<h3 id="chatinstruction">Tap on your frient to chat!!!</h3>
	</div>
	<div id="boxoffriends">
		<div>
			<a href="show_messages?id=1">
				<fieldset class="friendinlist">
					<legend>Priti Tripathi</legend>
					<br>
					<p>Last Chatted :</p>
					<span>Today</span>
				</fieldset>
			</a>
		</div>
		<div>
			<a href="show_messages?id=2">
				<fieldset class="friendinlist">
					<legend>Prakash Singh</legend>
					<br>
					<p>Last Chatted :</p>
					<span>Today</span>
				</fieldset>
			</a>
		</div>
		<div>
			<a href="show_messages?id=3">
				<fieldset class="friendinlist">
					<legend>Md Javed</legend>
					<br>
					<p>Last Chatted :</p>
					<span>Today</span>
				</fieldset>
			</a>
		</div>
	</div>

</body>
</html>