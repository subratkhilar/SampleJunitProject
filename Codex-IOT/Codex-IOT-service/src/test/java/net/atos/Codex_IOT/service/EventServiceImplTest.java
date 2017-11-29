package net.atos.Codex_IOT.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import net.atos.Codex_IOT.dao.AssetDao;
import net.atos.Codex_IOT.dao.CustomerDao;
import net.atos.Codex_IOT.dao.EventDao;
import net.atos.Codex_IOT.dao.ProjectDao;
import net.atos.Codex_IOT.dao.SensorDao;
import net.atos.Codex_IOT.model.EventModels;
import net.atos.Codex_IOT.model.IOTEventStatusModel;
import net.atos.Codex_IOT.pojo.Event;

@RunWith(MockitoJUnitRunner.class)
public class EventServiceImplTest {
	@Mock
	EventDao eventdao;

	@Mock
	ProjectDao projectdao;

	@Mock
	AssetDao assetdao;
	@Mock
	SensorDao sensordao;
	@Mock
	CustomerDao customerdao;
	@InjectMocks
	private EventService eventService = new EventServiceImpl();

	@Test
	public void testGetallevent() {
		List<Event> list = new ArrayList<Event>();
		Event event = new Event();
		event.setEventId(100L);
		event.setEventdesc("sample desc");
		event.setEventtype("desk");
		list.add(event);
		when(eventdao.getallevent()).thenReturn(list);
		List<Event> results = eventService.getallevent();
		assertEquals(1, results.size());

	}

	@Test
	public void testGeteventbystatus() {
		List<Event> list = new ArrayList<Event>();
		Event event = new Event();
		event.setEventId(100L);
		event.setEventdesc("sample desc");
		event.setEventtype("desk");
		event.setStatus("completed");
		list.add(event);
		when(eventdao.geteventbystatus("completed")).thenReturn(list);
		List<Event> eventList = eventService.geteventbystatus("completed");
		// Validation
		assertNotNull(eventList);
		assertEquals(list.size(), eventList.size());
	}

	@Test
	public void testUpdateEventByEventId() {
		IOTEventStatusModel iotevent = new  IOTEventStatusModel();
		boolean msg=false;
		iotevent.setEventId("100");
		Event event = new Event();
		event.setEventId(100L);
		event.setEventdesc("sample desc");
		event.setEventtype("desk");
		event.setStatus("failure");
		when(eventdao.getEventByEventId(1L)).thenReturn(event);
		boolean result = eventService.updateEventByEventId(iotevent);
		assertFalse(result);
	}
	@Test
	public void testUpdateEventByEventId_sucess() {
		IOTEventStatusModel iotevent = new  IOTEventStatusModel();
		boolean msg=false;
		iotevent.setEventId("23");
		Event event = new Event();
		event.setEventId(23L);
		event.setEventdesc("sample desc");
		event.setEventtype("desk");
		event.setStatus("success");
		when(eventdao.getEventByEventId(Long.parseLong(iotevent.getEventId()))).thenReturn(event);
		//boolean result = eventService.updateEventByEventId(iotevent);
	//	System.out.println("sucess >> "+result);
		//assertFalse(result);
	}
	@Test
	public void testGetallEventbyCustomerID() {
		long customerId=1L;
		
		List<EventModels> eventModelList = new ArrayList<EventModels>();
		EventModels model = new EventModels();
		model.setAssetId("As001");
		model.setEventdesc("sample desc");
		model.setEventId(23L);
		model.setEventtype("Type1");
		eventModelList.add(model);
		Event event = new Event();
		event.setEventId(23L);
		event.setEventdesc("sample desc");
		event.setEventtype("Type1");
		event.setStatus("success");
		List<Event> eventList = new ArrayList<Event>();
		when(eventdao.getallEventbyCustomerID(customerId)).thenReturn(eventList);
		List<EventModels> eventModelList1 = eventService.getallEventbyCustomerID(customerId);
		assertNotNull(eventModelList1);
	}

	@Test
	public void testNoOfEventsByCustomerId() {
		long customerId =100L;
		Event event = new Event();
		event.setEventId(23L);
		event.setEventdesc("sample desc");
		event.setEventtype("desk");
		event.setStatus("success");
		when(eventdao.noOfEventsByCustomerId(customerId)).thenReturn(1);
		int result = eventService.noOfEventsByCustomerId(customerId);
		assertEquals(1, result);
		
	}

	@Test
	public void testUpdateAllEventStatus_faliure() {
		List<IOTEventStatusModel> eventStatusModels = new ArrayList<IOTEventStatusModel>();
		IOTEventStatusModel model = new IOTEventStatusModel();
		model.setEventId("100");
		model.setStatus("success");
		eventStatusModels.add(model);
		//when(astdao.getAssetbyId("As001")).thenReturn(asset);
		/* when(astdao.updateasset(asset)).thenReturn("");*/
		//eventService.updateAllEventStatus(eventStatusModels);
		//doNothing().when(astdao).updateasset(asset);
	}
	@Test
	public void testUpdateAllEventStatus_sucess() throws RuntimeException {
		List<IOTEventStatusModel> eventStatusModels = new ArrayList<IOTEventStatusModel>();
		IOTEventStatusModel model = new IOTEventStatusModel();
		model.setEventId("1");
		model.setStatus("success");
		eventStatusModels.add(model);
	//	Event
		//when(eventdao.getEventByEventId(1L)).thenReturn(eventStatusModels);
		//when(astdao.getAssetbyId("As001")).thenReturn(asset);
		/* when(astdao.updateasset(asset)).thenReturn("");*/
	//	eventService.updateAllEventStatus(eventStatusModels);
		//doNothing().when(astdao).updateasset(asset);
	}
}
