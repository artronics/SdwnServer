package artronics.sdwn.server.resources.asm;

import artronics.sdwn.server.controller.BlogEntryController;
import artronics.sdwn.server.model.BlogEntry;
import artronics.sdwn.server.resources.BlogEntryResource;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.mvc.ResourceAssemblerSupport;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;

public class BlogEntryResourceAsm extends ResourceAssemblerSupport<BlogEntry, BlogEntryResource>
{
    public BlogEntryResourceAsm()
    {
        super(BlogEntryController.class, BlogEntryResource.class);
    }

    @Override
    public BlogEntryResource toResource(BlogEntry blogEntry) {
        BlogEntryResource res = new BlogEntryResource();
        res.setTitle(blogEntry.getTitle());
        Link link = linkTo(BlogEntryController.class).slash(blogEntry.getId()).withSelfRel();
        res.add(link);
        return res;
    }
}
