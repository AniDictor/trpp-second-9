package ru.mirea.trppsecond9.controllers;

import com.opencsv.bean.CsvToBeanBuilder;
import io.micronaut.http.HttpResponse;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import ru.mirea.trppsecond9.entity.Nomenclature;

import java.io.InputStreamReader;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

/** Контроллер для работы с номенклатурами. */
@Controller("/employee")
public class NomenclatureController {

    /** Список номенклатур. */
    private final List<Nomenclature> nomenclatureList;

    /** Конструктор. */
    public NomenclatureController() {
        nomenclatureList = new CsvToBeanBuilder<Nomenclature>(
                new InputStreamReader(
                        Objects.requireNonNull(
                                this.getClass().getResourceAsStream("/MOCK_DATA.csv")))
        ).withType(Nomenclature.class).build().parse();
    }

    /**
     * Получить список номенклатур.
     * @return список номенклатур
     */
    @Get()
    public HttpResponse<List<Nomenclature>> getNomenclatures() {
        return HttpResponse.ok(nomenclatureList);
    }

    /**
     * Найти номенклатуру по идентификатору.
     * @param id идентификатор номенклатуры
     * @return Номенклатура, если есть, иначе 404 ошибка
     */
    @Get("/{id}")
    public HttpResponse<Nomenclature> findById(Long id) {
        Optional<Nomenclature> result = nomenclatureList.stream().filter(it -> it.getId().equals(id)).findAny();
        if (result.isPresent()) {
            return HttpResponse.ok(result.get());
        } else {
            return HttpResponse.notFound();
        }
    }
}
