package fr.kabiro.lol.ism.core.controller;

import fr.kabiro.lol.ism.core.dto.BuildDto;
import fr.kabiro.lol.ism.core.dto.ItemSetDto;
import fr.kabiro.lol.ism.core.model.Region;
import fr.kabiro.lol.ism.core.pojo.ZipFile;
import fr.kabiro.lol.ism.core.service.ItemSetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

@RestController
public class ItemSetController {

    @Autowired
    private ItemSetService itemSetService;

    @RequestMapping("/api/sets/v1/{region}/{name}")
    public List<BuildDto> itemsSetByUser(@PathVariable("name") String name, @PathVariable("region") Region region) {
        return itemSetService.findItemsSetByUser(name, region);
    }

    @RequestMapping("/api/sets/v1/{region}/{name}/followed")
    public List<BuildDto> followedItemsSetByUser(@PathVariable("name") String name, @PathVariable("region") Region region) {
        return itemSetService.findFollowedItemsSetByUser(name, region);
    }

    @RequestMapping(value = "/api/sets/v1/{region}/{name}/followed/{id}", method = RequestMethod.PUT)
    public void followItemSet(@PathVariable("name") String name, @PathVariable("region") Region region, @PathVariable("id") Long buildId) {
        itemSetService.followItemSet(name, region, buildId);
    }

    @RequestMapping(value = "/api/sets/v1/{region}/{name}/followed/{id}", method = RequestMethod.DELETE)
    public void unfollowItemSet(@PathVariable("name") String name, @PathVariable("region") Region region, @PathVariable("id") Long buildId) {
        itemSetService.unfollowItemSet(name, region, buildId);
    }

    @RequestMapping("/api/sets/v1/{id}")
    public BuildDto itemsSetById(@PathVariable("id") Long id) {
        return itemSetService.findItemsSetById(id).get();
    }

    @RequestMapping("/api/sets/v1/{region}/{name}/zip")
    public void zip(HttpServletResponse response, @PathVariable("name") String name, @PathVariable("region") Region region) {
        try {
            response.setHeader("Content-Disposition", "attachment; filename=Config.zip");
            ZipOutputStream zos = new ZipOutputStream(response.getOutputStream());

            List<ZipFile> zipFiles = itemSetService.findZippedItemsSetByUser(name, region);

            for (ZipFile zipFile : zipFiles) {
                zos.putNextEntry(new ZipEntry(zipFile.getPath()));
                zos.write(zipFile.getFileContent());
                zos.closeEntry();
            }
            zos.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @RequestMapping("/api/sets/v1/game/{region}/{gameId}")
    public Map<Integer, ItemSetDto> itemsSetFromGame(@PathVariable("gameId") Long gameId, @PathVariable("region") Region region) {
        return itemSetService.itemsSetFromGame(gameId, region);
    }

    @RequestMapping(value = "/api/sets/v1/", method = RequestMethod.PUT)
    public BuildDto create(@RequestParam Set<String> champions, @RequestParam String summonerName, @RequestParam Region summonerRegion, @RequestBody ItemSetDto itemSet) {
        return itemSetService.create(champions, summonerName, summonerRegion, itemSet);
    }

    @RequestMapping(value = "/api/sets/v1/{id}", method = RequestMethod.POST)
    public BuildDto update(@PathVariable("id") Long buildId, @RequestParam Set<String> champions, @RequestBody ItemSetDto itemSet) {
        return itemSetService.update(buildId, champions, itemSet);
    }

    @RequestMapping(value = "/api/sets/v1/{id}", method = RequestMethod.DELETE)
    public void delete(@PathVariable("id") Long buildId) {
        itemSetService.delete(buildId);
    }
}
