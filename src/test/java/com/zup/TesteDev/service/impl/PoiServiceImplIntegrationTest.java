package com.zup.TesteDev.service.impl;

import com.zup.TesteDev.TesteDevApplication;
import com.zup.TesteDev.domain.Poi;
import com.zup.TesteDev.dto.PoiDTO;
import com.zup.TesteDev.repository.PoiRepository;
import com.zup.TesteDev.service.PoiService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.ContextConfiguration;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@SpringBootTest
@ContextConfiguration(classes = TesteDevApplication.class)
public class PoiServiceImplIntegrationTest {

    @TestConfiguration
    static class PoiServiceImplTestContextConfiguration {

        @Bean
        public PoiService stateService() {
            return new PoiServiceImpl();
        }
    }

    @Autowired
    private PoiService poiService;

    @MockBean
    private PoiRepository poiRepository;

    @BeforeEach
    public void setUp() {

        List<Poi> poiList = new ArrayList<>();
        Poi poi1 = new Poi((long)1, "Lanchonete", 27, 12);
        Poi poi2 = new Poi((long)2, "Posto", 31, 18);
        Poi poi3 = new Poi((long)3, "Joalheiria", 15, 12);
        Poi poi4 = new Poi((long)4, "Floricultura", 19, 21);
        Poi poi5 = new Poi((long)5, "Pub", 12, 8);
        Poi poi6 = new Poi((long)6, "Supermercado", 23, 6);
        Poi poi7 = new Poi((long)7, "Churrascaria", 28, 2);

        poiList.add(poi1);
        poiList.add(poi2);
        poiList.add(poi3);
        poiList.add(poi4);
        poiList.add(poi5);
        poiList.add(poi6);
        poiList.add(poi7);

        Mockito.when(poiRepository.findAll())
                .thenReturn(poiList);
    }

    @Test
    public void whenListPoisByCoordinate_thenReturnPois() {
        Integer cord_x = 20;
        Integer cord_y = 10;
        Integer d_max = 10;

        PoiDTO poiDTO1 = new PoiDTO((long)1, "Lanchonete", 27, 12);
        PoiDTO poiDTO2 = new PoiDTO((long)2, "Joalheiria", 15, 12);
        PoiDTO poiDTO3 = new PoiDTO((long)3, "Pub", 12, 8);
        PoiDTO poiDTO4 = new PoiDTO((long)4, "Supermercado", 23, 6);

        List<PoiDTO> poiDTOList = new ArrayList<>();

        poiDTOList.add(poiDTO1);
        poiDTOList.add(poiDTO2);
        poiDTOList.add(poiDTO3);
        poiDTOList.add(poiDTO4);

        List<PoiDTO> list = poiService.listPoisByProx(cord_x, cord_y, d_max);

        assertThat(list.get(0).getName()).isEqualTo(poiDTOList.get(0).getName());
        assertThat(list.get(1).getName()).isEqualTo(poiDTOList.get(1).getName());
        assertThat(list.get(2).getName()).isEqualTo(poiDTOList.get(2).getName());
        assertThat(list.get(3).getName()).isEqualTo(poiDTOList.get(3).getName());
    }
}
