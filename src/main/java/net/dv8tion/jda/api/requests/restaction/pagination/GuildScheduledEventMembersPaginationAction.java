/*
 * Copyright 2015 Austin Keener, Michael Ritter, Florian Spieß, and the JDA contributors
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package net.dv8tion.jda.api.requests.restaction.pagination;

import net.dv8tion.jda.api.entities.Guild;
import net.dv8tion.jda.api.entities.Member;

import javax.annotation.Nonnull;

/**
 * {@link PaginationAction PaginationAction} that paginates the guild scheduled event users endpoint.
 * <br>Note that this implementation is not considered thread-safe as modifications to the cache are not done
 * with a lock. Calling methods on this class from multiple threads is not recommended.
 *
 * <h2>Limits:</h2>
 * Minimum - 1
 * <br>Maximum - 100
 *
 * <h2>Example</h2>
 * <pre>{@code
 * // Get every member interested in this event and DM them a notification
 * public static void getInterestedMembers(GuildScheduledEvent event) {
 *     // get paginator
 *     GuildScheduledEventMembersPagination members = event.retrieveGuildScheduledEventMembers();
 *     // DM every member
 *     members.forEachAsync((member) ->
 *         member.getUser().openPrivateChannel().queue(privateChannel -> privateChannel.sendMessage("Event starts in 30 minutes!").queue());
 *     );
 * }
 * }</pre>
 */
public interface GuildScheduledEventMembersPaginationAction extends PaginationAction<Member, GuildScheduledEventMembersPaginationAction>
{
    /**
     * The current target {@link Guild Guild} for
     * this GuildScheduledEventMembersPaginationAction.
     *
     * @return The never-null target Guild
     */
    @Nonnull
    Guild getGuild();
}
