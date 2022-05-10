package com.example.wicket.panel.list;

import com.example.wicket.services.DataService;
import com.example.wicket.vo.AddressVO;
import com.example.wicket.vo.ZipVo;
import org.apache.wicket.extensions.markup.html.repeater.data.table.IColumn;
import org.apache.wicket.extensions.markup.html.repeater.data.table.PropertyColumn;
import org.apache.wicket.markup.html.panel.Panel;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.Model;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ListPanel extends Panel {
    private String search;

    public ListPanel(String id, String search) {
        super(id);
        this.search = search;
    }

    public ListPanel(String id, IModel<?> model) {
        super(id, model);
    }

    @Override
    protected void onInitialize() {
        super.onInitialize();

        List<IColumn<AddressVO, String>> columns = new ArrayList<>();
        columns.add(new PropertyColumn<>(Model.of("Irányítószám"), "zip"));
        columns.add(new PropertyColumn<>(Model.of("Város"), "city"));
        columns.add(new PropertyColumn<>(Model.of("Cím"), "address"));
        add(new CustomDataTable<>("tablePanel", columns,
                new SortableContactDataProvider<AddressVO>(100) {
                    @Override
                    public Iterator<AddressVO> getData(long first, long count) {
                        List<AddressVO> result = new ArrayList<>();
                        for (AddressVO zip : DataService.addressList) {
                            if (zip.getZip().equals(search)) {
                                result.add(zip);
                            }
                        }
                        size = (long) result.size();
                        return result.iterator();
                    }
                }, 100));
    }
}
