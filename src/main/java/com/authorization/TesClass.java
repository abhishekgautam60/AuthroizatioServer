package com.authorization;

public class TesClass {

	@GET
	public Response authorize(@Context HttpServletRequest request)
	        throws URISyntaxException, OAuthSystemException {
	    try {
	        OAuthAuthzRequest oauthRequest = new OAuthAuthzRequest(request);
	        OAuthIssuerImpl oauthIssuerImpl = new OAuthIssuerImpl(new MD5Generator());
	        //build response according to response_type
	        String responseType = oauthRequest.getParam(OAuth.OAUTH_RESPONSE_TYPE);
	        OAuthASResponse.OAuthAuthorizationResponseBuilder builder =
	                OAuthASResponse.authorizationResponse(request, HttpServletResponse.SC_FOUND);

	        //Authz code
	        if (responseType.equals(ResponseType.CODE.toString())) {
	            final String authorizationCode = oauthIssuerImpl.authorizationCode();
	            database.addAuthCode(authorizationCode);
	            builder.setCode(authorizationCode);
	        }

	        //Build response and redirect to given in request URI
	        String redirectURI = oauthRequest.getParam(OAuth.OAUTH_REDIRECT_URI);
	        final OAuthResponse response = builder.location(redirectURI).buildQueryMessage();
	        URI url = new URI(response.getLocationUri());

	        //Send reponse to given URI
	        return Response.status(response.getResponseStatus()).location(url).build();
	}
}
