# frozen_string_literal: true

require "runapi/core"
require_relative "heygen_video/types"
require_relative "heygen_video/resources/text_to_video"
require_relative "heygen_video/resources/image_to_video"
require_relative "heygen_video/client"

module RunApi
  module HeyGenVideo
    AuthenticationError = RunApi::Core::AuthenticationError
    RateLimitError = RunApi::Core::RateLimitError
    InsufficientCreditsError = RunApi::Core::InsufficientCreditsError
    NotFoundError = RunApi::Core::NotFoundError
    ValidationError = RunApi::Core::ValidationError
    TaskFailedError = RunApi::Core::TaskFailedError
    TaskTimeoutError = RunApi::Core::TaskTimeoutError
  end
end
