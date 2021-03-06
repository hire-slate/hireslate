

<div id="login" class="w3-modal">
	<span onclick="document.getElementById('login').style.display='none'"
		class="w3-button w3-display-topright">&times;</span>

	<div class="wrap-login100 p-l-55 p-r-55 p-t-65 p-b-50">

		<form class="login100-form validate-form" method="Post" action ="/user/login">

			<span class="login100-form-title p-b-33"> Account Login </span>

			<div class="wrap-input100 validate-input"
				data-validate="Valid email is required: ex@abc.xyz">
				<input class="input100" type="text" name="username" placeholder="Email">
				<span class="focus-input100-1"></span> <span
					class="focus-input100-2"></span>
			</div>

			<div class="wrap-input100 rs1 validate-input"
				data-validate="Password is required">
				<input class="input100" type="password" name="password"
					placeholder="Password"> <span class="focus-input100-1"></span>
				<span class="focus-input100-2"></span>
			</div>

			<div class="container-login100-form-btn m-t-20">
				<input class="login100-form-btn" name="loginBtn" type="submit"  value = "sign in">
			</div>

			<div class="text-center p-t-45 p-b-4">
				<span class="txt1"> Forgot </span> <a href="#" class="txt2 hov1">
					Username / Password? </a>
			</div>
			<div class="text-center">
				<span class="txt1"> Create an account? </span> <a href="#"
					class="txt2 hov1"> Sign up </a>
			</div>
		</form>
	</div>
</div>


<div class="hero-wrap js-fullheight">
	<div class="overlay"></div>
	<div class="container-fluid px-0">
		<div
			class="row d-md-flex no-gutters slider-text align-items-end js-fullheight justify-content-end">
			<img class="one-third align-self-end order-md-last img-fluid"
				src="${pageContext.request.contextPath}/resources/frontend/images/undraw_work_time_lhoj.svg"
				alt="">
			<div
				class="one-forth d-flex align-items-center ftco-animate js-fullheight">
				<div class="text mt-5">
					<p class="mb-4 mt-5 pt-5">
						We have <span class="number" data-number="200000">0</span> great
						job offers you deserve!
					</p>
					<h1 class="mb-5">Largets Job Site In The World</h1>

					<div class="ftco-search">
						<div class="row">
							<div class="col-md-12 nav-link-wrap">
								<div class="nav nav-pills text-center" id="v-pills-tab"
									role="tablist" aria-orientation="vertical">
									<a class="nav-link active mr-md-1" id="v-pills-1-tab"
										data-toggle="pill" href="#v-pills-1" role="tab"
										aria-controls="v-pills-1" aria-selected="true">Find a Job</a>

									<a class="nav-link" id="v-pills-2-tab" data-toggle="pill"
										href="#v-pills-2" role="tab" aria-controls="v-pills-2"
										aria-selected="false">Find a Candidate</a>

								</div>
							</div>
							<div class="col-md-12 tab-wrap">

								<div class="tab-content p-4" id="v-pills-tabContent">

									<div class="tab-pane fade show active" id="v-pills-1"
										role="tabpanel" aria-labelledby="v-pills-nextgen-tab">
										<form action="#" class="search-job">
											<div class="row no-gutters">
												<div class="col-md mr-md-2">
													<div class="form-group">
														<div class="form-field">
															<div class="icon">
																<span class="icon-briefcase"></span>
															</div>
															<input type="text" class="form-control"
																placeholder="eg. Garphic. Web Developer">
														</div>
													</div>
												</div>
												<div class="col-md mr-md-2">
													<div class="form-group">
														<div class="form-field">
															<div class="select-wrap">
																<div class="icon">
																	<span class="ion-ios-arrow-down"></span>
																</div>
																<select name="" id="" class="form-control">
																	<option value="">Category</option>
																	<option value="">Full Time</option>
																	<option value="">Part Time</option>
																	<option value="">Freelance</option>
																	<option value="">Internship</option>
																	<option value="">Temporary</option>
																</select>
															</div>
														</div>
													</div>
												</div>
												<div class="col-md mr-md-2">
													<div class="form-group">
														<div class="form-field">
															<div class="icon">
																<span class="icon-map-marker"></span>
															</div>
															<input type="text" class="form-control"
																placeholder="Location">
														</div>
													</div>
												</div>
												<div class="col-md">
													<div class="form-group">
														<div class="form-field">
															<button type="submit"
																class="form-control btn btn-secondary">Search</button>
														</div>
													</div>
												</div>
											</div>
										</form>
									</div>

									<div class="tab-pane fade" id="v-pills-2" role="tabpanel"
										aria-labelledby="v-pills-performance-tab">
										<form action="#" class="search-job">
											<div class="row">
												<div class="col-md">
													<div class="form-group">
														<div class="form-field">
															<div class="icon">
																<span class="icon-user"></span>
															</div>
															<input type="text" class="form-control"
																placeholder="eg. Adam Scott">
														</div>
													</div>
												</div>
												<div class="col-md">
													<div class="form-group">
														<div class="form-field">
															<div class="select-wrap">
																<div class="icon">
																	<span class="ion-ios-arrow-down"></span>
																</div>
																<select name="" id="" class="form-control">
																	<option value="">Category</option>
																	<option value="">Full Time</option>
																	<option value="">Part Time</option>
																	<option value="">Freelance</option>
																	<option value="">Internship</option>
																	<option value="">Temporary</option>
																</select>
															</div>
														</div>
													</div>
												</div>
												<div class="col-md">
													<div class="form-group">
														<div class="form-field">
															<div class="icon">
																<span class="icon-map-marker"></span>
															</div>
															<input type="text" class="form-control"
																placeholder="Location">
														</div>
													</div>
												</div>
												<div class="col-md">
													<div class="form-group">
														<div class="form-field">
															<button type="submit"
																class="form-control btn btn-secondary">Search</button>
														</div>
													</div>
												</div>
											</div>
										</form>
									</div>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</div>

<section class="ftco-section services-section bg-primary">
	<div class="container">
		<div class="row d-flex">
			<div class="col-md-3 d-flex align-self-stretch ftco-animate">
				<div class="media block-6 services d-block">
					<div class="icon">
						<span class="flaticon-resume"></span>
					</div>
					<div class="media-body">
						<h3 class="heading mb-3">Search Millions of Jobs</h3>
						<p>A small river named Duden flows by their place and
							supplies.</p>
					</div>
				</div>
			</div>
			<div class="col-md-3 d-flex align-self-stretch ftco-animate">
				<div class="media block-6 services d-block">
					<div class="icon">
						<span class="flaticon-collaboration"></span>
					</div>
					<div class="media-body">
						<h3 class="heading mb-3">Easy To Manage Jobs</h3>
						<p>A small river named Duden flows by their place and
							supplies.</p>
					</div>
				</div>
			</div>
			<div class="col-md-3 d-flex align-self-stretch ftco-animate">
				<div class="media block-6 services d-block">
					<div class="icon">
						<span class="flaticon-promotions"></span>
					</div>
					<div class="media-body">
						<h3 class="heading mb-3">Top Careers</h3>
						<p>A small river named Duden flows by their place and
							supplies.</p>
					</div>
				</div>
			</div>
			<div class="col-md-3 d-flex align-self-stretch ftco-animate">
				<div class="media block-6 services d-block">
					<div class="icon">
						<span class="flaticon-employee"></span>
					</div>
					<div class="media-body">
						<h3 class="heading mb-3">Search Expert Candidates</h3>
						<p>A small river named Duden flows by their place and
							supplies.</p>
					</div>
				</div>
			</div>
		</div>
	</div>
</section>


<section id="section-counter" class="ftco-section ftco-count img"
	style="background-image: url(${pageContext.request.contextPath}/resources/frontend/images/bg_1.jpg);"
	data-stellar-background-ratio="0.5">
	<div class="container">
		<div class="row justify-content-center">
			<div class="col-md-12">
				<div class="row">
					<div
						class="col-md-3 d-flex justify-content-center counter-wrap ftco-animate">
						<div class="block-18 text-center">
							<div class="text">
								<div class="icon">
									<span class="flaticon-employee"></span>
								</div>
								<strong class="number" data-number="435000">0</strong> <span>Jobs</span>
							</div>
						</div>
					</div>
					<div
						class="col-md-3 d-flex justify-content-center counter-wrap ftco-animate">
						<div class="block-18 text-center">
							<div class="text">
								<div class="icon">
									<span class="flaticon-collaboration"></span>
								</div>
								<strong class="number" data-number="40000">0</strong> <span>Members</span>
							</div>
						</div>
					</div>
					<div
						class="col-md-3 d-flex justify-content-center counter-wrap ftco-animate">
						<div class="block-18 text-center">
							<div class="text">
								<div class="icon">
									<span class="flaticon-resume"></span>
								</div>
								<strong class="number" data-number="30000">0</strong> <span>Resume</span>
							</div>
						</div>
					</div>
					<div
						class="col-md-3 d-flex justify-content-center counter-wrap ftco-animate">
						<div class="block-18 text-center">
							<div class="text">
								<div class="icon">
									<span class="flaticon-promotions"></span>
								</div>
								<strong class="number" data-number="10500">0</strong> <span>Company</span>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>


</section>




