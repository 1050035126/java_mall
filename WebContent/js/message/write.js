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
																			'����Ӧ��Ϊ3-20λ֮��');
														} else {
															$(this)
																	.next()
																	.text(
																			'������ȷ');
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