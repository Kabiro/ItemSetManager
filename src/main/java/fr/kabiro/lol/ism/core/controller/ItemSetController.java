package fr.kabiro.lol.ism.core.controller;

import fr.kabiro.lol.ism.core.dto.ItemSetDto;
import fr.kabiro.lol.ism.core.model.Region;
import fr.kabiro.lol.ism.core.pojo.ZipFile;
import fr.kabiro.lol.ism.core.service.ItemSetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

@RestController
public class ItemSetController {

    @Autowired
    private ItemSetService itemSetService;

    @RequestMapping("/api/sets/v1/{region}/{name}")
    public List<ItemSetDto> itemsSetByUser(@PathVariable("name") String name, @PathVariable("region") Region region) {
        return itemSetService.findItemsSetByUser(name, region);
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
    public List<ItemSetDto> itemsSetFromGame(@PathVariable("gameId") Long gameId, @PathVariable("region") Region region) {
        return itemSetService.itemsSetFromGame(gameId, region);
    }

}
