				$(document)
						.ready(
								function() {
									$("#inputTitle")
											.blur(
													function() {
														if ($("#inputTitle")
																.val().length < 3
																|| $(
																		"#inputTitle")
																		.val().length > 20) {
															$(this)
																	.next()
																	.text(
																			'标题应该为3-20位之间');
														} else {
															$(this)
																	.next()
																	.text(
																			'输入正确');
														}
													});

									$(".submit")
											.click(
													function() {
														if ($("#inputTitle")
																.val().length < 3
																|| $(
																		"#inputTitle")
																		.val().length > 20) {
															$("#inputTitle")
																	.next()
																	.css(
																			"background-color",
																			"red");
															return false;
														} else {
															$("#inputTitle")
																	.next()
																	.css(
																			"background-color",
																			"green");
															$("#WriteForm")
																	.submit();
															return true;
														}
													});

								});