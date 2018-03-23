$(function () {

  function goToByScroll(id){
    id = id.replace("link", "");
    $('html,body').animate({
      scrollTop: $("#"+id).offset().top},
      'slow');
  }

  $(".navbar a").click(function(e) {
    e.preventDefault();
    goToByScroll($(this).attr("id"));
  });

  $('.news-modal').on('show.bs.modal', function() {
    $(".navbar").addClass("d-none");
  });
  $('.news-modal').on('hidden.bs.modal', function() {
    $(".navbar").removeClass("d-none");
  });

  $('.nav-link').click(function() {
    $('.navbar-collapse').collapse('hide');
  });

  discordWidget.init({
      serverId: '228885878427222016',
      title: 'Pwny Express Discord',
      join: false,
      alphabetical: false,
      theme: 'dark',
      hideChannels: false,
      showAllUsers: true,
      allUsersDefaultState: true
  });
  discordWidget.render();

  $(document).on('click', '[data-toggle="lightbox"]', function(event) {
    event.preventDefault();
    $(this).ekkoLightbox();
  });

  $.getJSON('https://raider.io/api/v1/guilds/profile?region=eu&realm=Arthas&name=Pwny%20Express&fields=raid_progression', function(data) {
    console.log(data);
    console.log(data.raid_progression["antorus-the-burning-throne"].summary);
  	$('#antorus-the-burning-throne .bosses').text(data.raid_progression["antorus-the-burning-throne"].summary);
  	$('#tomb-of-sargeras .bosses').text(data.raid_progression["tomb-of-sargeras"].summary);
  	$('#trial-of-valor .bosses').text(data.raid_progression["trial-of-valor"].summary);
  	$('#the-emerald-nightmare .bosses').text(data.raid_progression["the-emerald-nightmare"].summary);
  	$('#the-nighthold .bosses').text(data.raid_progression["the-nighthold"].summary);
  }).fail(function(error) {
    console.log( error );
  });

  $.getJSON('https://raider.io/api/v1/guilds/profile?region=eu&realm=Arthas&name=Pwny%20Express&fields=raid_rankings', function(data) {
    console.log(data);
    console.log(data.raid_rankings["antorus-the-burning-throne"].mythic.world);
  	$('#antorus-the-burning-throne .world').html(data.raid_rankings["antorus-the-burning-throne"].mythic.world);
  	$('#antorus-the-burning-throne .eu').html(data.raid_rankings["antorus-the-burning-throne"].mythic.region);
  	$('#antorus-the-burning-throne .realm').html(data.raid_rankings["antorus-the-burning-throne"].mythic.realm);

  	$('#tomb-of-sargeras .world').html(data.raid_rankings["tomb-of-sargeras"].mythic.world);
  	$('#tomb-of-sargeras .eu').html(data.raid_rankings["tomb-of-sargeras"].mythic.region);
  	$('#tomb-of-sargeras .realm').html(data.raid_rankings["tomb-of-sargeras"].mythic.realm);

  	$('#trial-of-valor .world').html(data.raid_rankings["trial-of-valor"].mythic.world);
  	$('#trial-of-valor .eu').html(data.raid_rankings["trial-of-valor"].mythic.region);
  	$('#trial-of-valor .realm').html(data.raid_rankings["trial-of-valor"].mythic.realm);

  	$('#the-emerald-nightmare .world').html(data.raid_rankings["the-emerald-nightmare"].mythic.world);
  	$('#the-emerald-nightmare .eu').html(data.raid_rankings["the-emerald-nightmare"].mythic.region);
  	$('#the-emerald-nightmare .realm').html(data.raid_rankings["the-emerald-nightmare"].mythic.realm);

  	$('#the-nighthold .world').html(data.raid_rankings["the-nighthold"].mythic.world);
  	$('#the-nighthold .eu').html(data.raid_rankings["the-nighthold"].mythic.region);
  	$('#the-nighthold .realm').html(data.raid_rankings["the-nighthold"].mythic.realm);
  }).fail(function(error) {
    console.log( error );
  });


});